package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaStream {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i <100; i++)
        {
            list.add(i);
        }

      Map<Integer,Integer> map=  list.stream().map(x-> x*2)
                .filter( y -> y> 10)

                .collect(Collectors.toMap( k-> k ,v->v*2 ));

        System.out.println(map.toString());




    }

}
