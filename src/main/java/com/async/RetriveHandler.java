package com.async;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;

public class RetriveHandler {

    public static void main(String[] args) {

        Vertx  vertx =Vertx.vertx();
        getfile(vertx);



    }

    private  static  Future<String> getfile(Vertx vertx) {

        Future<String> future =Future.future();
        vertx.fileSystem().readFile("filename",ar -> future.handle(ar.map(Buffer::toString)));

        return future;
    }
    private  static  Future<String> getSecondfile(Vertx vertx) {

        Future<String> future =Future.future();

        vertx.fileSystem().readFile("filename",
                ar -> future.handle(ar.map(Buffer::toString)));
        return future;
    }
}
