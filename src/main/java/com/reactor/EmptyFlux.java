package com.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EmptyFlux {

    public static void main(String[] args) {
//        Flux  flux =emptyFlux();
//        flux.log().subscribe(System.out::println);
//
//       Flux  flux1 =fooBarFluxFromValues();
//       flux1.log().subscribe(System.out::println);
//
//        Flux  flux2 =fooBarFluxFromList();
//        flux2.log().subscribe(System.out::println);



        Flux  flux4 =counter();
        flux4.log().subscribe(System.out::println);



    }

   static Flux<String> emptyFlux() {
        return Flux.empty();
    }
    // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    static Flux<String> fooBarFluxFromValues() {

        Flux  flux =Flux.just("x","y","z");
        return flux;
    }
    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
   static  Flux<String> fooBarFluxFromList() {
        List<String> lst =new ArrayList<>();
        lst.add("foo");
       lst.add("bar");
       Flux  flux =Flux.fromIterable(lst);
       return flux;
    }
   static  Flux<String> errorFlux() {

       List lst =new ArrayList<>();
       lst.add("foo");
       lst.add(2);
       Flux  flux = Flux.error(new IllegalArgumentException());
       return flux;
    }
    static  Flux<Long> counter() {


        // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms

            List<Integer> lst =new ArrayList<>();
            lst.add(1);
            lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);

        Flux<Long>  result =   Flux.interval(Duration.ofMillis(100)).take(10);

           return result;
        }





}
