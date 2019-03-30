package com.reactive.rxjava;

import io.reactivex.Observable;

public class ConditionalOperators {
    public static void main(String[] args) {
        final StringBuilder result = new StringBuilder();
        Observable.empty()
                .defaultIfEmpty("No Data")
                .subscribe(s -> result.append(s));
        System.out.println(result);
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        final StringBuilder result1 = new StringBuilder();
        Observable.fromArray(letters)
                .firstElement()
                .defaultIfEmpty("No data")
                .subscribe(s -> result1.append(s));
        System.out.println(result1);
    }
}

/*
* 1
All

Evaluates all items emitted to meet given criteria.

2
Amb

Emits all items from the first Observable only given multiple Observables.

3
Contains

Checks if an Observable emits a particular item or not.

4
DefaultIfEmpty

Emits default item if Observable do not emit anything.

5
SequenceEqual

Checks if two Observables emit the same sequence of items.

6
SkipUntil

Discards items emitted by first Observable until a second Observable emits an item.

7
SkipWhile

Discard items emitted by an Observable until a given condition becomes false.

8
TakeUntil

Discards items emitted by an Observable after a second Observable emits an item or terminates.

9
TakeWhile

Discard items emitted by an Observable after a specified condition becomes false.
* */
