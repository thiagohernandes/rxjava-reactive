package com.reactive.rxjava;

import io.reactivex.Observable;

public class CombineLatestObservable {
    public static void main(String[] args) {
        Integer[] numbers = { 1, 2, 3, 4, 5, 6};
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        final StringBuilder result = new StringBuilder();
        Observable<String> observable1 = Observable.fromArray(letters);
        Observable<Integer> observable2 = Observable.fromArray(numbers);
        Observable.combineLatest(observable2, observable1, (a,b) -> a + b)
                .subscribe( letter -> result.append(letter));
        System.out.println(result);
    }
}
/*
1	And/Then/When
Combine item sets using Pattern and Plan intermediaries.

2	CombineLatest
Combine the latest item emitted by each Observable via a specified function and emit resulted item.

3	Join
Combine items emitted by two Observables if emitted during time-frame of second Observable emitted item.

4	Merge
Combines the items emitted of Observables.

5	StartWith
Emit a specified sequence of items before starting to emit the items from the source Observable

6	Switch
Emits the most recent items emitted by Observables.

7	Zip
Combines items of Observables based on function and emits the resulted items.
* */
