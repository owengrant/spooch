package io.pet.spooch.request

import com.geoideas.eventx.shared.EventServiceVertxEBProxy
import io.pet.spooch.COMMENT_CREATED
import io.pet.spooch.database.tables.daos.CommentDao
import io.pet.spooch.database.tables.pojos.Comment
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CommentHandler(
        val cDao: CommentDao,
        context: String,
        vertx: Vertx,
        eventstore: EventServiceVertxEBProxy
    ) : Handler(vertx, context, eventstore) {

    fun postComment(ctx: RoutingContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val comment = Comment().fromJson(ctx.bodyAsJson)
                        .setUid(ctx.user().principal().getInteger("id"))
                        .setEvent(COMMENT_CREATED)
                val id = cDao.insertReturningPrimary(comment).await()
                reply(ctx, 201, mes = JsonObject().put("id", id))
            } catch (e: Exception) {
                replyFailAndPrint(ctx, e = e)
            }
        }
    }

    fun getComments(ctx: RoutingContext){
        val eid = ctx.pathParam("event_id").toInt()
        try{
            GlobalScope.launch(vertx.dispatcher()){
                val comments = awaitResult<List<Comment>>{ cDao.findManyByEid(listOf(eid)).setHandler(it) }
                reply(ctx, mes = JsonArray(comments.map(Comment::toJson)))
            }
        }catch(e: Exception) { replyFailAndPrint(ctx, e = e) }
    }
}