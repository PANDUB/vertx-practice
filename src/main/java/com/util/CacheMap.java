package com.util;

import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class CacheMap  implements  ICacheMap{

         Map<Object, JsonObject> map =new HashMap<>();



    @Override
    public void add(Object key, JsonObject value) {

        map.put(key,value);

    }

    @Override
    public JsonObject get(Object key) {
       return map.get(key);
    }
}
