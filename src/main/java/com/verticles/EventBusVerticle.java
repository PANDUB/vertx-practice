package com.verticles;

import io.vertx.core.AbstractVerticle;


public class EventBusVerticle  extends AbstractVerticle {


    @Override
    public void start() {

        vertx.eventBus().<String>consumer("sample.ex", msg -> {
            System.out.println("[EventBusVerticle] Consuming data in " + Thread.currentThread().getName());
            String jsonObject = msg.body();
            System.out.println("[EventBusVerticle] Consuming data in " + Thread.currentThread().getName());


           msg.reply("hello"+jsonObject);

        });



    }
}
