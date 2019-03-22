/*
package io.pet.spooch.poll

import com.geoideas.eventx.shared.EventDTO
import com.geoideas.eventx.shared.EventService
import io.pet.spooch.PASSWORD_CHANGED
import io.pet.spooch.USER_CREATED
import io.pet.spooch.database.Tables.USER
import io.pet.spooch.database.tables.daos.UserDao
import io.pet.spooch.database.tables.pojos.User
import io.pet.spooch.database.tables.records.UserRecord
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.kotlin.coroutines.await
import org.jooq.UpdateFromStep
import org.jooq.UpdateSetFirstStep

open class UserPoll (
        val uDao: UserDao,
        vertx: Vertx,
        eventstore: EventService,
        context: String)
    : Poll(vertx, eventstore, context) {

    override suspend fun handle(event: EventDTO): Boolean {

        return when(event.event){
            USER_CREATED -> createUser(event)
            PASSWORD_CHANGED -> changePassword(event)
            else -> false
        }
    }

    private suspend fun createUser(event: EventDTO): Boolean {
        val successData = JsonObject().put("id", event.entityId)
        val operation = suspend { uDao.insert(User().fromJson(seed(event))).await() }
        val task = ExecuteTask(0, event.hash, successData, operation, EventDTO())
        uDao.queryExecutor().beginTransaction().compose {
            it.execute { it.insertInto(USER, USER.USERNAME, USER.PASSWORD, USER.EVENTID, USER.REVISION, USER.ENTITYID, USER.HASH) }
        }
        return execute(task)
    }

    private suspend fun changePassword(event: EventDTO): Boolean {
        val data = event.data
        val newPass = data.getString("new_password")
        val user = User().fromJson(event.data)
        return execute(0, event.hash, JsonObject().put("id", user.entityid)) {
            uDao.queryExecutor().execute {
                seedUpdate(it.update(USER), event).set(USER.PASSWORD,newPass)
                .where(
                        USER.USERNAME.eq(user.username)
                        .and(USER.PASSWORD.eq(user.password))
                        .and(USER.HASH.eq(user.hash))
                )
            }.await()
        }
    }

    private fun seedUpdate(start: UpdateSetFirstStep<UserRecord>, event: EventDTO) =
             start.set(USER.REVISION, event.revision)
            .set(USER.HASH, event.hash).set(USER.EVENTID, event.eventId)
}
*/