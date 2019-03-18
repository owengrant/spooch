/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pet.spooch.request

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventServiceVertxEBProxy
import io.pet.spooch.INSERT
import io.pet.spooch.USERCREATED
import io.pet.spooch.USER_ENTITY
import io.pet.spooch.database.tables.daos.UserDao
import io.pet.spooch.database.tables.pojos.User
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerRequest
import io.vertx.core.json.JsonObject
import io.vertx.core.logging.LoggerFactory
import io.vertx.ext.auth.jwt.JWTAuth
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.kotlin.coroutines.dispatcher
import io.vertx.kotlin.ext.jwt.JWTOptions
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *
 * @author Owen Grant
 */
class AccountHandler(
        val uDao: UserDao,
        val jwtAuth: JWTAuth,
        context: String,
        vertx: Vertx, eventStore: EventServiceVertxEBProxy
    ) : Handler(vertx, context, eventStore) {

    val log = LoggerFactory.getLogger("io.pet.AccountHandler")

    fun validateCreate(body: JsonObject): Boolean {
        var p1 = body.getString("password")
        var p2 = body.getString("password_confirm")
        var username = body.getString("username")
        return p1.equals(p2) && p1.length >= 7 && username.isNotBlank()
    }

    fun validateChangePassword(body: JsonObject) = body.getString("password").length >= 7

    fun createJWT(user: User?,res: HttpServerRequest): String{
        return jwtAuth.generateToken(
                JsonObject().put("sub",user!!.username).put("id",user.id),
                JWTOptions(algorithm = "HS256")
        )
    }

    fun createUser(ctx: RoutingContext){
        val body = ctx.bodyAsJson
        if(!validateCreate(body)) {
            ctx.fail(400)
            return
        }
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val user  = User().fromJson(body)
                val username = user.username
                val curUser =  uDao.findOneByUsername(username).await()
                if(curUser != null)
                    reply(ctx, 400, "user with username $username already exist")
                else {
                    val hash = helper.generateHash(listOf(user.username,user.password))
                    val entityId = helper.generateHash(hash)
                    val event = EventDTO(context, hash, USERCREATED, INSERT, entityId, USER_ENTITY, 1, user.toJson())
                    helper.publish(event, eventstore).await()
                    //let next handler deal with request
                    ctx.put("hash", hash)
                    ctx.next()
                }
            } catch (e: Exception) { replyFailAndPrint(ctx, e = e) }
        }
    }

    fun loginUser(ctx: RoutingContext){
        val user = User().fromJson(ctx.bodyAsJson)
        GlobalScope.launch(vertx.dispatcher()){
            try{
                val vUser = awaitResult<User?> { uDao.findOneByUsername(user.username).setHandler(it) }
                if(user.password == vUser?.password ?: "") reply(ctx,mes = createJWT(vUser,ctx.request()))
                else reply(ctx,400,"Incorrect username or password")
            } catch (e: Exception){ replyFailAndPrint(ctx, e = e) }
        }
    }

    fun changePassword(ctx: RoutingContext){
        val body = ctx.bodyAsJson
        if(!validateChangePassword(body)) {
            ctx.fail(400)
            return
        }
        val username = ctx.user().principal().getString("sub")
        val newPass = body.getString("new_password")
        val password = body.getString("password")
        GlobalScope.launch(vertx.dispatcher()){
            try{
                val user = awaitResult<User?> { uDao.findOneByUsername(username).setHandler(it) }
                if(password == user?.password ?: ""){
                    val id = awaitResult<Int> { uDao.update(user!!.setPassword(newPass)).setHandler(it) }
                    reply(ctx,mes = "Password update successful")
                } else reply(ctx,400,"Incorrect password")
            } catch(e: Exception) { replyFailAndPrint(ctx, e = e)}
        }
    }
}
