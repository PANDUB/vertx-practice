package com.completablefuture;

import io.netty.util.concurrent.CompleteFuture;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class FutureWhenComplete {

    public static void main(String[] args) {

        CompletableFuture<String> completeFuture ;

        completeFuture =getdata();

        completeFuture.whenComplete((x,y) ->
        {
            if(Objects.nonNull(y))
            {

                System.out.println("error in loop"+ y.getMessage());
            }
            if(Objects.nonNull(x)) {
                System.out.println("ok in loop"+ x.toString());
            }

        });

    }


    public  static CompletableFuture<String>  getdata()
    {

        CompletableFuture<String>  completableFuture =
                CompletableFuture.supplyAsync( () -> new String());
          completableFuture.complete("hello");
        return completableFuture;

    }
}
