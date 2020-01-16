package com.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;



public  abstract class GenericHandler  implements Handler<RoutingContext> {


    public abstract void handle( RoutingContext routingContext);






}
