package io.pet.spooch

import io.pet.spooch.database.tables.daos.CommentDao
import io.pet.spooch.database.tables.daos.EventDao
import io.pet.spooch.database.tables.daos.TagDao
import io.pet.spooch.database.tables.daos.UserDao
import io.pet.spooch.eventstore.EventService
import io.pet.spooch.handlers.AccountHandler
import io.pet.spooch.handlers.CommentHandler
import io.pet.spooch.handlers.EventHandler
import io.pet.spooch.handlers.TagHandler
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

    final val log = LoggerFactory.getLogger("io.pet.spooch.Gateway")

    override suspend fun start() {
        val routerFactory = OpenAPI3RouterFactory.createAwait(vertx,config.getString("openapi"))
        val jwtAuth = jwtSecurity()
        routerFactory.addSecurityHandler("JwtAuth", JWTAuthHandler.create(jwtAuth))

        val dbClient = dbClient()
        val sqlConfig = DefaultConfiguration().set(SQLDialect.POSTGRES_10)

        val eventStore = EventService.createProxy(vertx,config.getString("eventstore"))

        val account = AccountHandler(UserDao(sqlConfig,dbClient),jwtAuth,vertx,eventStore)
        routerFactory.addHandlerByOperationId("createUser",account::createUser)
        routerFactory.addHandlerByOperationId("loginUser",account::loginUser)
        routerFactory.addHandlerByOperationId("changePassword",account::changePassword)

        val event = EventHandler(EventDao(sqlConfig,dbClient),vertx,eventStore)
        routerFactory.addHandlerByOperationId("loadEvents",event::loadEvents)
        routerFactory.addHandlerByOperationId("postEvent",event::postEvent)

        val tag = TagHandler(TagDao(sqlConfig,dbClient),vertx,eventStore)
        routerFactory.addHandlerByOperationId("tagEvent",tag::addTag)
        routerFactory.addHandlerByOperationId("getEventTags",tag::getTags)

        val comment = CommentHandler(CommentDao(sqlConfig,dbClient),vertx,eventStore)
        routerFactory.addHandlerByOperationId("postComment",comment::postComment)
        routerFactory.addHandlerByOperationId("getComments",comment::getComments)

        val router = routerFactory.router
        startServer(router)
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

    private fun startServer(router: Router) =
        vertx.createHttpServer()
            .requestHandler(router)
            .listen(
                    config.getInteger("port"),
                    config.getString("host")
            ) { log.info(if(it.succeeded()) "Server running" else it.cause().message) }

}