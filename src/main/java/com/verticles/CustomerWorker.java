package com.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.VertxOptions;

public class CustomerWorker extends AbstractVerticle {


    @Override
    public void start(Future<Void> future) throws Exception {


        System.out.println("[Worker] Starting in " + Thread.currentThread().getName());
        vertx.eventBus().<String>consumer("sample.data", message -> {
            System.out.println("[Worker] Consuming data in " + Thread.currentThread().getName());
            String body = message.body();
            message.reply(body.toUpperCase());
        });



    }
}
