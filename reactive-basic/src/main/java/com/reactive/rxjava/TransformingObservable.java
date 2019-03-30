package com.reactive.rxjava;

import io.reactivex.Observable;

public class TransformingObservable {
    public static void main(String[] args) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        final StringBuilder result = new StringBuilder();
        Observable<String> observable = Observable.fromArray(letters);
        observable
                .map(String::toUpperCase)
                .subscribe( letter -> result.append(letter + "T\t"));
        System.out.println(result);
    }
}
