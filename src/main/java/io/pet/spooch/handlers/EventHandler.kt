package io.pet.spooch.handlers

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventServiceVertxEBProxy
import io.pet.spooch.database.tables.daos.EventDao
import io.pet.spooch.database.tables.pojos.Event
import io.pet.spooch.response.ResponseHandler
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.setHandlerAwait
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class EventHandler(
        val eDao: EventDao,
        context: String,
        vertx: Vertx,
        eventstore: EventServiceVertxEBProxy
    ) : Handler(vertx, context , eventstore) {

    fun loadEvents(ctx: RoutingContext){
        GlobalScope.launch(vertx.dispatcher()) {
            val events = eDao.findAll().setHandlerAwait()
            reply(ctx, mes = JsonArray(events.map(Event::toJson)))
        }
    }

    fun postEvent(ctx: RoutingContext){
        try{
            GlobalScope.launch(vertx.dispatcher()){
                val event = Event().fromJson(ctx.bodyAsJson)
                event.uid = ctx.user().principal().getInteger("id")
                val id = eDao.insertReturningPrimary(event).setHandlerAwait()
                reply(ctx,201,mes = JsonObject().put("id",id))

            }
        } catch (e: Exception) { replyFailAndPrint(ctx,e = e)}
    }
}