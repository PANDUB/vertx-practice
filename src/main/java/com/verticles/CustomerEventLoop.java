package com.verticles;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.guicemodule.GuiceModule;
import com.handlers.GenericHandler;
import com.util.ICacheMap;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.cli.impl.ReflectionUtils;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.HashMap;
import java.util.Map;

public class CustomerEventLoop extends AbstractVerticle {


   @Inject ICacheMap  cacheMap;



    @Override
    public void start() throws Exception {

       // Injector  injector=Guice.createInjector(new GuiceModule());
        //cacheMap =injector.getInstance(ICacheMap.class);


        setupdata();
        Router router = Router.router(vertx);
        router.get("/products/:productID").handler(this::handleGetProduct);
     //   router.post("/customer/add").handler(req-> injector.getInstance(GenericHandler.class).handle());
        router.put("/customer/update").handler(this::handleGetProduct);
        System.out.println("welcome to EventLoop");
        vertx.createHttpServer(new HttpServerOptions()).
                requestHandler(router).
                listen(8081);


    }
    private void handleGetProduct(RoutingContext routingContext) {

        String productid =routingContext.request().getParam("productID");
        HttpServerResponse response =routingContext.response();
        if(productid ==null)
        {
          response.setStatusCode(403);
          response.end();
        }
        else {

            JsonObject  product =cacheMap.get(productid);
            vertx.eventBus().send(
                    "sample.data",
                    "hello vert.x",
                    r -> {
                        System.out.println("[Main] Receiving reply ' " + r.result().body()
                                + "' in " + Thread.currentThread().getName());
                    }
            );

           response.putHeader("content-type", "application/json").end(product.encodePrettily());

            response.setStatusCode(200);

        }



    }

    private void setupdata()
    {

        addProduct(new JsonObject().put("id", "prod3568").put("name", "Egg Whisk").put("price", 3.99).put("weight", 150));
        addProduct(new JsonObject().put("id", "prod7340").put("name", "Tea Cosy").put("price", 5.99).put("weight", 100));
        addProduct(new JsonObject().put("id", "prod8643").put("name", "Spatula").put("price", 1.00).put("weight", 80));


    }
    private void addProduct(JsonObject product)
    {
        cacheMap.add(product.getString("id") ,product);


    }




}
