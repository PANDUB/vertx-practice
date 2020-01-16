package com.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class NonBlockComplete {

    public static void main(String[] args) {


         AtomicReference<Integer> s = new AtomicReference<>(0);

        CompletableFuture<String>  completableFuture=CompletableFuture.supplyAsync(()->
        {
            try {
              //  Thread.sleep(200);
                return "hello";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        });

        completableFuture.whenComplete((res,error)->
        {
            if(res.equalsIgnoreCase("hello"))
            {
               s.set(10);
               getadd(10);
            }

            else {
                s.set(20);
                getadd(200);
            }
        });


        System.out.println("hi"+s.get());
    }

    public static void getadd(int i)
    {

        System.out.println("result"+i+10);
    }
}
