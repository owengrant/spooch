package io.pet.spooch.handlers

import com.geoideas.eventx.shared.EventServiceVertxEBProxy
import io.pet.spooch.handlers.utils.EventHelper
import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext

open class Handler(
        val vertx: Vertx,
        val context: String,
        val eventstore: EventServiceVertxEBProxy) {

    val helper = EventHelper(context)

    open fun reply(ctx: RoutingContext, code: Int = 200, mes: String = "Success") {
        val res = ctx.response()
        if (code != 200)
            res.setStatusMessage(mes)
        res.setStatusCode(code)
           .end(mes)
    }
    open fun reply(ctx: RoutingContext, code: Int = 200, mes: JsonObject) = reply(ctx,code,mes.encode())

    open fun reply(ctx: RoutingContext, code: Int = 200, mes: JsonArray) = reply(ctx,code,mes.encode())

    open fun replyFailAndPrint(ctx: RoutingContext, code: Int = 500, e: Exception){
        ctx.fail(code)
        e.printStackTrace()
    }

}