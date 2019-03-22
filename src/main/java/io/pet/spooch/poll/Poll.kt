/*
package io.pet.spooch.poll

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventService
import io.pet.spooch.RES_HANDLER
import io.pet.spooch.response.ResponseHandler
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.kotlin.core.eventbus.DeliveryOptions
import io.vertx.kotlin.coroutines.awaitEvent

abstract class Poll (
            val vertx: Vertx,
            val eventstore: EventService,
            val context: String) {

    abstract suspend fun handle(event: EventDTO): Boolean

    open suspend fun pause(delay: Long){
        if(delay > 0) awaitEvent<Long> { vertx.setTimer(delay, it) }
    }

    open suspend fun execute(delay: Long, hash: String ,data: JsonObject, operation: suspend () -> Any): Boolean{
        var pause = false
        var err = ""
        try {
            pause(delay)
            operation()
        } catch(e: Exception){
            err = "error"
            if(e.localizedMessage.contains("Connection refused")) pause = true
            e.printStackTrace()
        } finally {
            //send message to rest response handler
            val op = DeliveryOptions().addHeader("hash", hash).addHeader("err", err)
            vertx.eventBus().publish(RES_HANDLER, data, op)
            return pause
        }
    }

    open suspend fun execute(task: ExecuteTask): Boolean{
        var pause = false
        var err = ""
        try {
            pause(task.delay)
            task.operation()
        } catch(e: Exception){
            err = "error"
            if(e.localizedMessage.contains("Connection refused")) pause = true
            e.printStackTrace()
        } finally {
            //send message to rest response handler
            val op = DeliveryOptions().addHeader("hash", task.hash).addHeader("err", err)
            vertx.eventBus().publish(RES_HANDLER, task.success, op)
            return pause
        }
    }

    open fun seed(event: EventDTO) =
        event.data.copy()
            .put("entityId", event.entityId)
            .put("eventId", event.eventId)
            .put("hash", event.hash)
            .put("revision", event.revision)
}
*/