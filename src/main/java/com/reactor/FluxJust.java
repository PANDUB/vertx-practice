package com.reactor;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.util.Arrays;
import java.util.List;

public class FluxJust {

    public static void main(String[] args) {

       // Flux<List<String>> flux =Flux.just(Arrays.asList("a","b","c","d","e"));
         Flux<Integer>   flux =Flux.generate(
                () -> Tuples.of(0, 1),
                (state, sink) -> {
                     sink.next(state.getT1());
                    if(state.getT1() > 10) sink.complete();
                    return Tuples.of(state.getT2(), state.getT1() + state.getT2())
                            ;
                });

         flux.log().subscribe(x-> System.out.println(x));


    }
}
