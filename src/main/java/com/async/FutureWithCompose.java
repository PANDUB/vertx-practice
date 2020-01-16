package com.async;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;

public class FutureWithCompose {

    public static void main(String[] args) {
        Future<Integer> future =Future.future();
        Future<Integer>  future1 = add(1,2);
        Future<Integer>  future2 = sub(10,20);

        CompositeFuture.all(future1,future2).setHandler(  ar -> {
            if(ar.succeeded())
            {
                System.out.println("successful");

            }
                });


        // CompositeFuture.all(future1,future2).complete();




    }

  static  Future<Integer>  add(int a, int b)
    {
        Future<Integer> future =Future.future();

        int result =a+b;

        future.complete(result);

        return future;


    }
    static  Future<Integer>  sub(int a, int b)
    {
        Future<Integer> future =Future.future();

        int result =a-b;

        future.complete(result);

        return future;


    }


}
