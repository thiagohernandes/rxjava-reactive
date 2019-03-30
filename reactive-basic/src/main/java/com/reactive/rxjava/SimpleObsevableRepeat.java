package com.reactive.rxjava;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public class SimpleObsevableRepeat {

    public static void main(String[] args)  throws InterruptedException {
        Single<Integer> testSingle;
        Disposable disposable;

        for(int x = 0; x < 11; x++) {
            testSingle = Single.just(x);
            disposable = execObserver(testSingle);
            Thread.sleep(3000);
            disposable.dispose();
        }
    }

    public static Disposable execObserver(Single<Integer> testSingle) {
       return testSingle
                .subscribeWith(
                        new DisposableSingleObserver<Integer>() {
                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }
                            @Override
                            public void onSuccess(Integer value) {
                                System.out.println(value);
                            }
                        });
    }
}
