package com.reactor;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

public class FluxChain {

    public static void main(String[] args) {

        Flux<String> flux = Flux.just("A");
        flux.map(s -> "foo" + s).
        subscribe(System.out::println);
        Publisher<Integer> source = Flux.range(1, 10);
    }
}
