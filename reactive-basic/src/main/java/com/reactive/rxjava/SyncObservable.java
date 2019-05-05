package com.reactive.rxjava;

import io.reactivex.Observable;

public class SyncObservable {

    public static void main(String...ars) {
        Observable.create(s -> {
            s.onNext("Hello World!");
            s.onNext("Hello World 2!");
            s.onComplete();
        }).subscribe(hello -> System.out.println(hello));

        Observable<Integer> o = Observable.create(s -> {
            s.onNext(1);
            s.onNext(2);
            s.onNext(3);
            s.onComplete();
        });
        o.map(i -> "Number " + i)
                .subscribe(s -> System.out.println(s));

        Observable<String> stringTest =  Observable.create(s -> {
            new Thread(() -> {
                s.onNext("one");
                s.onNext("two");
                s.onNext("three");
                s.onNext("four");
                s.onComplete();
            }).start();
        });

        stringTest.subscribe(i -> {
            System.out.println(i);
        });
    }
}
