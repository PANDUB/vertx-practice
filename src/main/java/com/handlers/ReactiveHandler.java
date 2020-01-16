package com.handlers;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class ReactiveHandler {


    public void handle(RoutingContext routingContext,Vertx vertx)
    {
        vertx.eventBus().send(
                "sample.ex",
                "vert.x",
                r -> {

                    routingContext.response().putHeader("Content-Type", "application/json");
                    JsonObject jsonObject=new JsonObject();
                    jsonObject.put("output",r.result().body().toString());
                    routingContext.response().end(jsonObject.encodePrettily());
                }
        );
  }






}
