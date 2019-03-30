package com.reactive.rxjava;

import io.reactivex.subjects.ReplaySubject;

public class SubjectReplay {
    public static void main(String[] args) {
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();

        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(value -> result1.append(value) );
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();

        //Output will be abcd
        System.out.println(result1);
        //Output will be abcd being ReplaySubject
        //as ReplaySubject emits all the items
        System.out.println(result2);
    }
}
