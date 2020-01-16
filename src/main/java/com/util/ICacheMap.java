package com.util;

import io.vertx.core.json.JsonObject;

public interface ICacheMap<T> {


    public void add(T key, JsonObject value);



    public JsonObject get(T key);



}
