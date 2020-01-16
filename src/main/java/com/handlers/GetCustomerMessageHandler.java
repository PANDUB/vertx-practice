package com.handlers;


import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class GetCustomerMessageHandler extends  GenericHandler{



    @Override
    public void handle(RoutingContext context) {

       String str= context.request().getParam("status");
       JsonObject jsonObject=  new  JsonObject().put(str,"hello");
       context.response().putHeader("Content-Type", "application/json");
       context.response().end(jsonObject.encode());


    }
}
