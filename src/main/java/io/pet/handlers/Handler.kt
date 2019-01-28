package io.pet.handlers

import io.vertx.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext

open class Handler(val vertx: Vertx) {

    open fun reply(ctx: RoutingContext, code: Int = 200, mes: String = "Success") =
        ctx.response()
                .setStatusCode(code)
                .setStatusMessage(mes)
                .end(mes)

    open fun reply(ctx: RoutingContext, code: Int = 200, mes: JsonObject) = reply(ctx,code,mes.encode())

    open fun reply(ctx: RoutingContext, code: Int = 200, mes: JsonArray) = reply(ctx,code,mes.encode())

    open fun replyFailAndPrint(ctx: RoutingContext, code: Int = 500, e: Exception){
        ctx.fail(code)
        e.printStackTrace()
    }
}