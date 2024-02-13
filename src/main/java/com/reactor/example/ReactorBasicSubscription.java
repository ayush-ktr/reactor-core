package com.reactor.example;

import com.reactor.util.ReactorResource;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

public class ReactorBasicSubscription {

	public static void main(String[] args) throws Exception {
		
		
		Flux<Integer> numberFlux = ReactorResource.intNumbersFlux();
		
		Disposable disposable = numberFlux.subscribe();
		
		// Cancel the Subscription
		disposable.dispose();
		
		//consumer with logging
		numberFlux.log().subscribe((e) -> {
			System.out.println(e);
		}, 
				// error handlder
				(e) -> System.out.println("Error "+e.getMessage()), 
				// on complete
				() -> {
					System.out.println("Event completed..!!");
		});
		
		System.in.read();
		
	}

}
