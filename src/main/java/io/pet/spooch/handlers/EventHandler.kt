package io.pet.spooch.handlers

import io.pet.spooch.database.tables.daos.EventDao
import io.pet.spooch.database.tables.pojos.Event
import io.pet.spooch.eventstore.EventDTO
import io.pet.spooch.eventstore.EventServiceVertxEBProxy
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.setHandlerAwait
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class EventHandler(val eDao: EventDao, vertx: Vertx, eventstore: EventServiceVertxEBProxy) : Handler(vertx,eventstore) {

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
                val postEvent = EventDTO(Random.nextInt(0,100000000).toString(),"EventCreated","INSERT",1,id,"EVENT",1,event.toJson().put("id",id))
                eventstore.publish(JsonObject().put("data", postEvent.toJson())) {
                    if(it.failed()) println(it.cause().message)
                    else println("EventCreated published")
                }
            }
        } catch (e: Exception) { replyFailAndPrint(ctx,e = e)}
    }
}