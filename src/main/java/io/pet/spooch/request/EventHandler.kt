package io.pet.spooch.request

import com.geoideas.eventx.shared.EventServiceVertxEBProxy
import io.pet.spooch.EVENT_CREATED
import io.pet.spooch.database.tables.daos.EventDao
import io.pet.spooch.database.tables.pojos.Event
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.setHandlerAwait
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EventHandler(
        val eDao: EventDao,
        context: String,
        vertx: Vertx,
        eventstore: EventServiceVertxEBProxy
    ) : Handler(vertx, context , eventstore) {

    fun loadEvents(ctx: RoutingContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try{
                val events = eDao.findAll().await()
                reply(ctx, mes = JsonArray(events.map(Event::toJson)))
            } catch (e: Exception) { replyFailAndPrint(ctx,e = e)}

        }
    }

    fun postEvent(ctx: RoutingContext){
        GlobalScope.launch(vertx.dispatcher()) {
            try {
                val event = Event().fromJson(ctx.bodyAsJson)
                        .setUid(ctx.user().principal().getInteger("id"))
                        .setEvent(EVENT_CREATED)
                val id = eDao.insertReturningPrimary(event).await()
                reply(ctx, 201, mes = JsonObject().put("id",id))
            } catch (e: Exception) { replyFailAndPrint(ctx,e = e)}

        }
    }
}