package com.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    private static ExecutorService  exec = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureDemo futureDemo =new FutureDemo();
        Future<Integer>  result1 =futureDemo.calculate(10);
        Future<Integer>  result2 =futureDemo.calculate(10);
        int k= 0;

        while(!(result1.isDone() && result2.isDone()))
        {



//            System.out.println(
//                    String.format(
//                            "future1 is %s and future2 is %s",
//                            result1.isDone() ? "done" : "not done",
//                            result2.isDone() ? "done" : "not done"
            //        ));
        }
       Integer  i =result1.get();

        Integer  j= result2.get();
        System.out.println(k);
        System.out.println(i+j);

        exec.shutdown();

    }

    private Future<Integer>  calculate(Integer a)  {
        return exec.submit(() -> {
            try {
                Thread.sleep(1000);
                final int i = a * a;
                return i;
            } finally {

            }

        });

    }


}
