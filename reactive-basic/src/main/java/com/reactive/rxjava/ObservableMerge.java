package com.reactive.rxjava;

import io.reactivex.Observable;

public class ObservableMerge {
    public static void main(String[] args) {
        Observable<String> a = Observable.create(s -> {
            new Thread(() -> {
                s.onNext("one");
                s.onNext("two");
                s.onComplete();
            }).start();
        });
        Observable<String> b = Observable.create(s -> {
            new Thread(() -> {
                s.onNext("three");
                s.onNext("four");
                s.onComplete();
            }).start();
        });
// this subscribes to a and b concurrently,
// and merges into a third sequential stream
        Observable<String> c = Observable.merge(a, b);
        c.subscribe(i -> {
            System.out.println(i);
        });
    }
}
