package io.pet;

import co.paralleluniverse.fibers.Suspendable;
import static io.vertx.ext.sync.Sync.awaitEvent;
import io.vertx.ext.sync.SyncVerticle;

public class Spooch extends SyncVerticle {

    @Suspendable
    @Override
    public void start() {
        long x = awaitEvent(h -> vertx.setTimer(1000, h));
        System.out.println(x);
    }

}
