package com.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombineTwoCompleteFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String>  completableFuture1 =CompletableFuture.supplyAsync(() ->
        {
              try {
                  Thread.sleep(10000);
                  return "hello";
              }
              catch (Exception e)
              {

              }
             return null;
        }).thenApply( s -> {

            return   "second"+s.toUpperCase();

        });


        //CompletableFuture<String>  completableFuture2 =CompletableFuture.supplyAsync(() -> new String("Second"));

       //CompletableFuture completableFuture=CompletableFuture.anyOf(completableFuture2);
               //completableFuture1.thenCombine(completableFuture2,(x,y)->  x+y);

        System.out.println(completableFuture1.get());


    }
}
