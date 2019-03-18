package io.pet.spooch.response

import io.vertx.core.eventbus.Message
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.RoutingContext

open class ResponseHandler {
     val rCtx = mutableMapOf<String,RoutingContext>()

    open fun handle(message: Message<JsonObject>) {
        val hash = message.headers().get("hash")
        val err = message.headers().get("err")
        val con = rCtx.getOrDefault(hash, null)
        if(con != null){
            if(err.isEmpty()){
                con.response().end(message.body().encode())
            } else con.fail(500)
            rCtx.remove(hash)
        }
    }

    fun put(hash: String, ctx: RoutingContext) = rCtx.put(hash, ctx)
}