package com.rxjava;

import io.vertx.core.Future;
import rx.Observable;

public class Observablecreate {

    public static void main(String[] args) {

        Observable<String> observable = Observable.just("a","v","c","d");
        observable.doOnNext( x -> System.out.println(x)).subscribe(x-> System.out.println( x.toLowerCase()));

    }
}
