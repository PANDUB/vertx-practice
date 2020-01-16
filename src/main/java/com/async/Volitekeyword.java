package com.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Volitekeyword {

    private static volatile Future<Integer> i ;

   private static  ExecutorService  exec = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {



       test(9);
        System.out.println(i);
    }

    private static Future<Integer> test(int k )
    {

        return  exec.submit(()-> k*k);
    }
}
