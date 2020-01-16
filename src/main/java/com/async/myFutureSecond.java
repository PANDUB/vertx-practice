package com.async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class myFutureSecond {


    public static int main(String[] args) throws InterruptedException, ExecutionException {

       List<List<String>>  lst =new ArrayList<>();

       lst.add(Arrays.asList("1"));

        ExecutorService  executorService = Executors.newSingleThreadExecutor();

       Future<Integer> future =executorService.submit(()->
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 10);
       if(future.isDone()){

           System.out.println("future completed");
           Thread.sleep(200);
       }

       int result =future.get();
        System.out.println(result);

        return result;
    }

}
