package io.pet.handlers

import io.pet.database.tables.daos.EventDao
import io.pet.database.tables.pojos.Event
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EventHandler(val eDao: EventDao, vertx: Vertx) : Handler(vertx) {

    fun loadEvents(ctx: RoutingContext){
        try{
            GlobalScope.launch(vertx.dispatcher()){
                val events = awaitResult<List<Event>>{ eDao.findAll().setHandler(it) }
                reply(ctx,mes = JsonArray(events.map(Event::toJson)))
            }
        } catch(e: Exception) { replyFailAndPrint(ctx, e = e) }
    }

    fun postEvent(ctx: RoutingContext){
        try{
            GlobalScope.launch(vertx.dispatcher()){
                val event = Event().fromJson(ctx.bodyAsJson)
                event.uid = ctx.user().principal().getInteger("id")
                val id = awaitResult<Int> { eDao.insertReturningPrimary(event).setHandler(it) }
                reply(ctx,201,mes = JsonObject().put("id",id))
            }
        } catch (e: Exception) { replyFailAndPrint(ctx,e = e)}
    }
}