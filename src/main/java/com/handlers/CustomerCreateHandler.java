package com.handlers;


import com.messages.internal.CustomerMessage;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class CustomerCreateHandler extends  GenericHandler{
    @Override
    public void handle(RoutingContext context) {
        JsonObject  jsonObject =context.getBodyAsJson();
        context.response().putHeader("Content-Type", "application/json");
        context.response().end(jsonObject.encode());
    }
}
