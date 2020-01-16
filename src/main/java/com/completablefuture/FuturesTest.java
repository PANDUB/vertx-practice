package com.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class FuturesTest

{

    public static void main(String[] args) {
        getBiconsumer((a,b)-> System.out.println(a+b));
        consumer((a)-> System.out.println(a));

    }

    public static void getBiconsumer(BiConsumer<Integer,Integer>  bi)
    {

        bi.accept(10,20);
    }

    public static void consumer(Consumer<String> c)
    {

        c.accept("hello");
    }


}
