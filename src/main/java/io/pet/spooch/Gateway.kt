package io.pet.spooch

import com.geoideas.eventx.shared.EventService
import io.pet.spooch.database.tables.daos.*
import io.pet.spooch.poll.DatabasePoll
import io.pet.spooch.request.AccountHandler
import io.pet.spooch.request.CommentHandler
import io.pet.spooch.request.EventHandler
import io.pet.spooch.request.TagHandler
import io.vertx.core.logging.LoggerFactory
import io.vertx.ext.asyncsql.PostgreSQLClient
import io.vertx.ext.auth.jwt.JWTAuth
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.JWTAuthHandler
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.ext.auth.PubSecKeyOptions
import io.vertx.kotlin.ext.auth.jwt.JWTAuthOptions
import io.vertx.kotlin.ext.web.api.contract.openapi3.OpenAPI3RouterFactory
import org.jooq.SQLDialect
import org.jooq.impl.DefaultConfiguration


class Gateway : CoroutineVerticle() {

    val log = LoggerFactory.getLogger("io.pet.spooch.Gateway")

    override suspend fun start() {
        val routerFactory = OpenAPI3RouterFactory.createAwait(vertx,config.getString("openapi"))
        val jwtAuth = jwtSecurity()
        routerFactory.addSecurityHandler("JwtAuth", JWTAuthHandler.create(jwtAuth))

        val dbClient = dbClient()
        val sqlConfig = DefaultConfiguration().set(SQLDialect.POSTGRES_10)

        val eventStore = EventService.create(vertx,config.getString("eventstore"))
        val context = config.getString("context")

        //rest handlers
        val uDao = UserDao(sqlConfig,dbClient)
        val account = AccountHandler(uDao,jwtAuth,context,vertx,eventStore)
        routerFactory.addHandlerByOperationId("createUser",account::createUser)
        routerFactory.addHandlerByOperationId("loginUser",account::loginUser)
        routerFactory.addHandlerByOperationId("changePassword",account::changePassword)

        val event = EventHandler(EventDao(sqlConfig,dbClient),context,vertx,eventStore)
        routerFactory.addHandlerByOperationId("loadEvents",event::loadEvents)
        routerFactory.addHandlerByOperationId("postEvent",event::postEvent)

        val tag = TagHandler(TagDao(sqlConfig,dbClient),context,vertx,eventStore)
        routerFactory.addHandlerByOperationId("tagEvent",tag::addTag)
        routerFactory.addHandlerByOperationId("getEventTags",tag::getTags)

        val comment = CommentHandler(CommentDao(sqlConfig,dbClient),context,vertx,eventStore)
        routerFactory.addHandlerByOperationId("postComment",comment::postComment)
        routerFactory.addHandlerByOperationId("getComments",comment::getComments)

        val router = routerFactory.router
        //start server
        startServer(router)

        val dbPoll = DatabasePoll(EventsourceDao(sqlConfig,dbClient),context,vertx,eventStore)
        vertx.setPeriodic(4000) { dbPoll.poll() }

        /*
        val responseHandler = ResponseHandler()
        vertx.eventBus().consumer<JsonObject>(RES_HANDLER, responseHandler::handle)
        router.route("/*").handler {
            val hash :String? = it.get("hash")
            if(hash != null) responseHandler.put(hash,it)
            else it.fail(500)
        }
        */
        val uPoll = UserPoll(uDao, vertx, eventStore, context)

        val LUID  = uDao.queryExecutor().query{ it.select(max(USER.EVENTID)).from(USER) }.setHandlerAwait().unwrap<RowImpl>().getInteger(0)

        val ids = listOf<Int>(LUID)
        println("LAST EVENTID: "+ids.max())
        val globalPoll = GlobalPoll(uPoll, vertx, eventStore, context, (ids?.max() ?: -1))

        vertx.setPeriodic(1000) { globalPoll.poll() }
        */
    }

    private fun jwtSecurity(): JWTAuth {
        val jwtConf = config.getJsonObject("jwt_auth")
        val conf = JWTAuthOptions(
            pubSecKeys = listOf(PubSecKeyOptions(
                algorithm = jwtConf.getString("algorithm"),
                publicKey = jwtConf.getString("public_key"),
                symmetric = true
            ))
        )
        return  JWTAuth.create(vertx, conf)
    }

    private fun dbClient() = PostgreSQLClient.createShared(vertx, config.getJsonObject("database"))

    private fun startServer(router: Router) {
        vertx
        .createHttpServer()
        .requestHandler(router)
        .listen(
                config.getInteger("port"),
                config.getString("host")
        ) { log.info(if (it.succeeded()) "Server running" else it.cause().message) }
    }
}