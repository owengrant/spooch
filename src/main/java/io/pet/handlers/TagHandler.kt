package io.pet.handlers

import io.pet.database.tables.daos.TagDao
import io.pet.database.tables.pojos.Tag
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TagHandler(val tDao: TagDao, vertx: Vertx) : Handler(vertx) {

    fun addTag(ctx: RoutingContext){
        try{
            GlobalScope.launch(vertx.dispatcher()) {
                val tag = Tag().fromJson(ctx.bodyAsJson)
                val id = awaitResult<Int> { tDao.insertReturningPrimary(tag).setHandler(it) }
                reply(ctx,201, JsonObject().put("id",id))
            }
        } catch(e: Exception) { replyFailAndPrint(ctx, e = e) }
    }

    fun getTags(ctx: RoutingContext){
        try{
            GlobalScope.launch(vertx.dispatcher()) {
                val eid = ctx.pathParam("event_id").toInt()
                val tags = awaitResult<List<Tag>>{ tDao.findManyByEid(listOf(eid)).setHandler(it) }
                reply(ctx,200, JsonArray(tags.map(Tag::toJson)))
            }
        } catch(e: Exception) { replyFailAndPrint(ctx, e = e) }
    }
}