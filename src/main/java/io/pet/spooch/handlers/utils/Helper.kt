package io.pet.spooch.handlers.utils

import io.vertx.core.Vertx
import io.vertx.ext.web.RoutingContext
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun onCoroutine(vertx: Vertx,ctx: RoutingContext, handler: suspend (RoutingContext) -> Unit){
    GlobalScope.launch(vertx.dispatcher()){
        try{
            handler(ctx)
        } catch (e: Exception) {
            ctx.fail(500)
            e.printStackTrace()
        }
    }
}