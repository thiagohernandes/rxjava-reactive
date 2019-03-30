package com.reactive.rxjava;

import io.reactivex.Observable;

public class TakeFilterObservable {
    public static void main(String[] args) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        final StringBuilder result = new StringBuilder();
        Observable<String> observable = Observable.fromArray(letters);
        observable
                .take(2)
                .subscribe( letter -> result.append(letter));
        System.out.println(result);
    }
}
