package com.reactor.example;

import org.reactivestreams.Subscription;

import com.reactor.util.ReactorResource;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class ReactorSubscriberSubscription {

	public static void main(String[] args) throws Exception {

		Flux<Integer> numberFlux = ReactorResource.intNumbersFlux();

		numberFlux.subscribe(new BaseSubscriber<Integer>() {
			@Override
			protected void hookOnSubscribe(Subscription subscription) {
				System.out.println("Subscribed..!!");
				request(1);
			}

			@Override
			protected void hookOnComplete() {
				System.out.println("Completed");
			}

			@Override
			protected void hookOnError(Throwable throwable) {
				System.err.println("Error " + throwable.getMessage());
			}

			@Override
			protected void hookOnNext(Integer value) {
				System.out.println("value got: " + value);
				if (value == 5) {
					cancel();
				}
				request(1);
			}

			@Override
			protected void hookOnCancel() {
				System.out.println("Cancelled..!!");
			}

		});
		
		System.in.read();

	}

}
