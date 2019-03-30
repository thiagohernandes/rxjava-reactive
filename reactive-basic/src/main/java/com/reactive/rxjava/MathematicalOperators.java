package com.reactive.rxjava;

import io.reactivex.Observable;

public class MathematicalOperators {
    public static void main(String[] args)  throws InterruptedException {
        Integer[] numbers = { 1, 2, 3, 4, 5, 6};
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        final StringBuilder result = new StringBuilder();
        Observable<String> observable1 = Observable.fromArray(letters);
        Observable<Integer> observable2 = Observable.fromArray(numbers);
        Observable.concat(observable1, observable2)
                .subscribe( letter -> result.append(letter));
        System.out.println(result);
    }
}
