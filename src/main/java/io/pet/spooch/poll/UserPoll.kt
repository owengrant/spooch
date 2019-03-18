package io.pet.spooch.poll

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventService
import io.pet.spooch.USERCREATED
import io.pet.spooch.database.tables.daos.UserDao
import io.pet.spooch.database.tables.pojos.User
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.kotlin.core.setHandlerAwait
import io.vertx.kotlin.coroutines.await
import io.vertx.kotlin.coroutines.awaitEvent
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

open class UserPoll (
        val uDao: UserDao,
        vertx: Vertx,
        eventstore: EventService,
        context: String)
    : Poll(vertx, eventstore, context) {

    override suspend fun handle(event: EventDTO): Boolean {
        return when(event.event){
            USERCREATED -> createUser(event)
            else -> false
        }
    }

    private suspend fun createUser(event: EventDTO): Boolean {
        return execute(0, event.hash, JsonObject().put("id", event.entityId)) {
            uDao.insert(User().fromJson(seed(event))).await()
        }
    }
}