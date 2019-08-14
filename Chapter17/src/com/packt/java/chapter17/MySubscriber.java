package com.packt.java.chapter17;

import java.util.concurrent.Flow;

public class MySubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        // Store reference
        this.subscription = subscription;

        // Ask for first item
        this.subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        // Print the item
        System.out.println(item.toString());

        // Ask for another
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("No more items!");
    }

}
