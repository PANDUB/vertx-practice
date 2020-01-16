package com.java8func;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConvertMaptoProp {

    public static void main(String[] args) {

        Boolean.valueOf("str");

        Map<String,Integer>  propmap =new HashMap<>();

        propmap.put("1",1);
        propmap.put("2",2);
        propmap.put("3",3);
        propmap.put("4",40);
        propmap.put("5",10);
        propmap.put("test",100);
        Properties  p =new Properties();
        propmap.computeIfAbsent("test", k-> k =="test" ? 20*2 :30);
        propmap.putIfAbsent("k",60);
        propmap.forEach((k,v) ->  p.setProperty(k,v.toString()) );

        System.out.println(p.toString());
    }
}
