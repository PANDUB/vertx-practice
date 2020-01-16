package com.reactor;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxwithZIp {

    public static void main(String[] args) {



        Flux<Integer>  evenNumbers =Flux.range(0,12).filter(x -> x%2 ==0 );

       Flux<Integer>  oddNumbers =Flux.range(0,12).filter(x -> x%2 >0 );
        evenNumbers.mergeWith(oddNumbers).subscribe(x-> System.out.println(x));

        //Map string with Integers
      //  Flux<String>  evenString =Flux.just("zero","second","four","six","eight");
      //  Flux.zip(evenNumbers,oddNumbers).subscribe(x-> System.out.println(x));

      // oddNumbers.zipWith(evenNumbers).map((x-> x.getT1()+x.getT2())).subscribe(x-> System.out.println(x));

//        List<String>  keys = Arrays.asList("1","2");
//        Flux<List> flux = Flux.just(Arrays.asList(1, 2), Arrays.asList(2, 4));
//        flux.zipWith(keys)

    }


}
