package com.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class FluxWithFlatmap {

    public static void main(String[] args) {

       Flux<List<Integer>> mono = Flux.just(Arrays.asList(1,2),Arrays.asList(3,4));

       mono.flatMap(x-> Flux.fromIterable(x)).log().subscribe(x-> System.out.println(x));
        mono.map(x-> Flux.fromIterable(x)).log().subscribe(x-> System.out.println(x));





    }
}
