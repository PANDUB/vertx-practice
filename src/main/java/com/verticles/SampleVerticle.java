package com.verticles;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guicemodule.GuiceModule;
import com.util.ICacheMap;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;

public class SampleVerticle  extends AbstractVerticle {




    public static void main(String[] args) {
        Vertx  vertx =Vertx.vertx();
        Injector injector= Guice.createInjector(new GuiceModule());
       // cacheMap =injector.getInstance(ICacheMap.class);
        vertx.deployVerticle(new SampleVerticle());

    }

    @Override
    public void start() throws Exception {
        method1();

    }

    private void method1()
    {
        Future<Buffer> future = readfile();

        Future<String> future2 =  future.compose(this::writeFile);

        future2.setHandler(ar -> {

            if(ar.succeeded())
            {
                System.out.println("Successfully written "+ar.result());
            }
            if(ar.failed())
            {
                System.out.println("failed written ");
            }
        });


    }

    private Future<Buffer>  readfile()
    {
        Future<Buffer> future = Future.future();

        vertx.fileSystem().readFile("src/main/resources/example03/read.txt", ar -> {

                    if (ar.succeeded()) {
                        future.complete(ar.result());
                    }
                    if (ar.failed()) {

                        future.fail(ar.cause());
                    }

                });
        return future;
    }

    private Future<String>  writeFile(Buffer input)
    {
        Future<String> future = Future.future();
        String file ="src/main/resources/example03/write.txt";

        vertx.fileSystem().writeFile(file,input, ar -> {

            if (ar.succeeded()) {

                future.complete(file);
            }
            if (ar.failed()) {

                System.out.println(ar.cause());
                future.fail(ar.cause());
            }

        });
        return future;
    }



}
