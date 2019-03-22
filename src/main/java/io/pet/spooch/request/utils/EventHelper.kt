package io.pet.spooch.request.utils

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventService
import io.vertx.core.Future
import io.vertx.core.json.JsonObject
import org.apache.commons.codec.digest.DigestUtils
import java.util.*

class EventHelper(val context: String) {

    fun generateHash(field: String) = generateHash(listOf(field))

    fun generateHash(fields: List<String>) =  DigestUtils.md5Hex(context+fields.joinToString()+Random().nextInt(Int.MAX_VALUE))

    fun publish(event: EventDTO, eventstore: EventService): Future<JsonObject> {
        val fut = Future.future<JsonObject>()
        eventstore.publish(event.toJson(), fut.completer())
        return fut
    }

}