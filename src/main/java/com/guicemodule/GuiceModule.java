package com.guicemodule;

import com.google.inject.AbstractModule;
import com.util.CacheMap;
import com.util.ICacheMap;
import io.vertx.core.Vertx;

public class GuiceModule extends AbstractModule {



    @Override
    protected void configure() {

      bind(ICacheMap.class).to(CacheMap.class).asEagerSingleton();


    }
}
