package com.java8func;

import java.util.function.Function;

public class ComplexFunc {


    public static void main(String[] args) {

        System.out.println(test(str -> Integer.valueOf(str),"1234"));

    }

    public static Integer test(Function<String, Integer> map,String x)
    {

       return  map.apply(x);
    }

}
