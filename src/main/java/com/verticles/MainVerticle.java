package com.verticles;



import com.handlers.CustomerCreateHandler;
import com.handlers.CustomerUpdateHandler;
import com.handlers.GetCustomerMessageHandler;
import com.handlers.ReactiveHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;


public class MainVerticle  extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture)
    {
        Future<Void>  future= prepareDatabase().compose(v -> startHttpServer());
        future.setHandler(resp -> {
                    if (resp.succeeded()) {
                        startFuture.complete();
                    } else {
                        startFuture.fail(resp.cause());
                    }
                }
            );



    }

    private Future<Void>  prepareDatabase()
    {
        Future<Void>  future =Future.future();
        try {
            Thread.sleep(2000);
            future.complete();
            System.out.println("prepared database");
        } catch (InterruptedException e) {

            System.out.println("Error preparing database"+e);
            future.fail(e.getCause());
        }


       return  future;

    }
    private Future<Void>  startHttpServer()
    {
        Future<Void>  future =Future.future();
        HttpServer  httpServer =vertx.createHttpServer();
        Router  router =Router.router(vertx);
        router.route().handler( BodyHandler.create());
        router.get("/customer/enquiry").handler( routingContext -> new GetCustomerMessageHandler().handle(routingContext));
        router.post("/customer/create").consumes("application/json").handler(routingContext -> new CustomerCreateHandler().handle(routingContext));
        router.post("/customer/update").handler(routingContext ->new CustomerUpdateHandler().handle(routingContext));
        router.post("/customer/reactive").handler(routingContext ->new ReactiveHandler().handle(routingContext,vertx));

        httpServer.requestHandler(router).listen(8080, ar -> {
            if(ar.succeeded()){
                System.out.println("server started successfully");
                future.complete();
            }
            else {
               future.fail(ar.cause());
            }
        });

        return  future;

    }

}
