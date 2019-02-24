package io.pet.handlers

import io.github.jklingsporn.vertx.jooq.shared.internal.QueryResult
import io.pet.database.tables.Event.EVENT
import io.pet.database.tables.daos.EventDao
import io.pet.database.tables.pojos.Event
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.core.setHandlerAwait
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.awaitResult
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EventHandler(val eDao: EventDao, vertx: Vertx) : Handler(vertx) {

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
                val id = awaitResult<Int> { eDao.insertReturningPrimary(event).setHandler(it) }
                reply(ctx,201,mes = JsonObject().put("id",id))

            }
        } catch (e: Exception) { replyFailAndPrint(ctx,e = e)}
    }
}