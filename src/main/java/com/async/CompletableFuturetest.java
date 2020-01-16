package com.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturetest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String>  completableFuture =CompletableFuture.supplyAsync(()->
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new String("hello11");
        });

        //completableFuture.complete("hello");

       System.out.println("hi"+completableFuture.get());



    }
}
