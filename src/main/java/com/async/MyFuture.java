package com.async;

import java.util.concurrent.*;

public class MyFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService  exec = Executors.newSingleThreadExecutor();

       Future<String>  future= exec.submit(() ->
        {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }, "true");


        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
        }
        System.out.println("Task completed! Retrieving the result");
        //String result = future.get();
       // System.out.println(result);

        exec.shutdown();
    }

    }

