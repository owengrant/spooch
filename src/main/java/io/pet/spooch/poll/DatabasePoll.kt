package io.pet.spooch.poll

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventServiceVertxEBProxy
import io.pet.spooch.database.Tables.EVENTSOURCE
import io.pet.spooch.database.tables.daos.EventsourceDao
import io.pet.spooch.database.tables.pojos.Eventsource
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.eventbus.ReplyException
import io.vertx.core.json.JsonObject
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.dispatcher
import io.vertx.serviceproxy.ServiceException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.ConnectException

open class DatabasePoll(val eDao: EventsourceDao, val context: String, val vertx: Vertx,val eventstore: EventServiceVertxEBProxy) {
    private val NO_HANDLER = "NO_HANDLERS,-1) No handlers for address"

    open fun poll(){
        GlobalScope.launch(vertx.dispatcher()){
            try{
                val events = eDao.findManyByCondition(EVENTSOURCE.SENT.eq(false),EVENTSOURCE.ID).await()
                events.forEach {
                    try{
                        val event = toEvent(it)
                        event.context = context
                        val fut = Future.future<JsonObject>()
                        eventstore.publish(event.toJson(),fut)
                        val data = fut.await()
                        markSent(it)
                    } catch(e: ServiceException){
                        val err = e as ReplyException
                        e.printStackTrace()
                        if(err.localizedMessage.startsWith(com.geoideas.eventx.shared.Error.DUPICATE)) markSent(it)
                        else return@launch
                    } catch (e: Exception){
                        e.printStackTrace()
                        return@launch
                    }
                }
            }
            catch(e: Exception){
                e.printStackTrace()
                return@launch
            }
        }
    }

    open suspend fun markSent(source: Eventsource){
        eDao.update(source.setSent(true))
    }

    open fun toEvent(source: Eventsource): EventDTO {
        val event = EventDTO()
        event.event = source.event
        event.eventType = source.eventtype
        event.entity = source.entity
        event.entityId = source.entityid
        event.revision = source.revision
        event.version = source.version
        event.data = JsonObject(source.data)
        return event
    }

}