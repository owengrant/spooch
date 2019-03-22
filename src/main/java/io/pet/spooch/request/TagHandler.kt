package io.pet.spooch.request

import com.geoideas.eventx.shared.EventServiceVertxEBProxy
import io.pet.spooch.TAG_CREATED
import io.pet.spooch.database.tables.daos.TagDao
import io.pet.spooch.database.tables.pojos.Tag
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TagHandler(
        val tDao: TagDao,
        context: String,
        vertx: Vertx, eventstore: EventServiceVertxEBProxy
    ) : Handler(vertx, context, eventstore){

    fun addTag(ctx: RoutingContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val tag = Tag().fromJson(ctx.bodyAsJson).setEvent(TAG_CREATED)
                val id = tDao.insertReturningPrimary(tag).await()
                reply(ctx, 201, JsonObject().put("id", id))
            } catch (e: Exception) {
                replyFailAndPrint(ctx, e = e)
            }
        }
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