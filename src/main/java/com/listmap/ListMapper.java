package com.listmap;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ListMapper {

    public static void main(String[] args) {

       try {
           List<String>  list =new ArrayList<>();
           FileInputStream  file =new FileInputStream("src/main/resources/app.properties");
           Properties  p =new Properties();
           p.load(file);
           p.forEach((k,v)-> list.add(v.toString()) );

           list.stream().allMatch( x->  x.equals("password"));


       } catch (IOException e) {
           e.printStackTrace();
       }



    }

    private static void mappertest() {
        List<Integer> l1 = new ArrayList<>();

        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

        flux.map(x -> l1.add(x)).subscribe();

        Map<String,Integer> map = l1.stream().map(x -> x*2).collect(Collectors.toMap(k -> k.toString() , v -> v));

        map.forEach((k ,v)-> System.out.println(k + "value"+ v));
    }
}
