/*
package io.pet.spooch.poll

import com.geoideas.eventx.shared.EventDTO
import io.vertx.core.json.JsonObject

data class ExecuteTask(
    val delay: Long,
    val hash: String,
    var success: JsonObject,
    var operation: suspend () -> Any,
    var event: EventDTO
)
*/