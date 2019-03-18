package io.pet.spooch.poll

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventService
import io.pet.spooch.USER_ENTITY
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.kotlin.core.setHandlerAwait
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.awaitEvent
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.stream.Collectors

open class GlobalPoll(
        val uPoll: Poll,
        val vertx: Vertx,
        val eventstore: EventService,
        val context: String,
        val nextEventId: Int
    ) {

    private var lastEventId = 0
    private var pause = false
    private val PAUSE_TIME: Long = 5000
    init {
        this.lastEventId = this.nextEventId
    }

    private fun toEvents(rawEvents: JsonArray) = rawEvents
                                                 .stream()
                                                 .map{ it as JsonObject }
                                                 .map{ EventDTO().fromJson(it) }
                                                 .collect(Collectors.toList())

    private fun pause() { this.pause = true }
    private fun pauseFor(mills: Long) {
        pause()
        vertx.setTimer(mills) { play() }
    }
    private  fun play() { this.pause = false }

    open fun poll() {
        if(!pause) {
            pause()
            GlobalScope.launch(vertx.dispatcher()) {
                try {
                    val fut = Future.future<JsonArray>()
                    eventstore.pollContext(lastEventId+1, context, fut.completer())
                    val events = fut.await()
                    var doPause = processEvents(toEvents(events))
                    if (doPause) pauseFor(PAUSE_TIME) else play()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    open suspend fun processEvents (events: List<EventDTO>): Boolean{
        var stop = false
        events.forEach loop@{
            stop = when(it.entity){
                USER_ENTITY -> uPoll.handle(it)
                else -> false
            }
            if(stop) return@loop else lastEventId = it.eventId
        }
        return stop
    }

}