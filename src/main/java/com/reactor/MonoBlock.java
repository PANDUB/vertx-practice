package com.reactor;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MonoBlock {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList(Arrays.asList(2, 3, 5, 3, 4));
        List<Integer> data2 = new ArrayList(Arrays.asList(1, 2, 3, 6, 4));
        AtomicInteger i = new AtomicInteger(0);

        Mono.just(data).subscribe(x ->
        {
            try {
                Thread.sleep(2000);
                i.set(x.get(0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        if (i.get() == 0) {
            System.out.println("hello --> " + i.get());
        } else if (i.get() == 2) {
            Mono.just(data2).subscribe(y -> {
                System.out.println("s"+y.get(2));


            });
        }
    }
}
