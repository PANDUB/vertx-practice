package com.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FluxFlatMap {

    public static void main(String[] args) throws InterruptedException {

      //  Flux<Integer>  flux1= Flux.fromIterable(Arrays.asList(1,2,3));
        List<Integer>  data =new ArrayList(Arrays.asList(1,2,3,4));
        Flux<String> flux1=  Flux.interval(Duration.ofMillis(500))
                .map(tick -> {
                    if(tick< data.size())
                    return "item " + tick + ": " + data.get(tick.intValue());
                    return "Done (tick == data.size())";

                        });


          List<List<String>>  l1 =new ArrayList<>();

        //  l1.stream().flatMap(x -> x.iterator());

        //  l1.stream().collect(Collectors.);


            Flux<Object> flux =   Flux.fromStream(()-> new ArrayList<>().stream());

        flux1.mergeWith(Flux.just("1"));
        flux1.take(data.size()+1).subscribe( System.out::println);

        Thread.sleep(3000);

    }
}
