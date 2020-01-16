package com.handlers;


import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class CustomerUpdateHandler extends  GenericHandler{



    @Override
    public void handle(RoutingContext context) {

        JsonObject  jsonObject =context.getBodyAsJson();
        jsonObject.put("request.gender","male");
        context.response().putHeader("Content-Type", "application/json");
        context.response().end(jsonObject.encode());


    }
}
