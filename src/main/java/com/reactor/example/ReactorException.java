package com.reactor.example;

import com.reactor.util.ReactorResource;

import reactor.core.publisher.Flux;

public class ReactorException {

	public static void main(String[] args) throws Exception {

		// Print values from intNumbersFluxWithException and print a message when error happens
		ReactorResource.intNumbersFluxWithException().subscribe(System.out::println, System.err::println);

		// Print values from intNumbersFluxWithException and continue on errors
		ReactorResource.intNumbersFluxWithException().onErrorContinue((e, item) -> System.out.println(e))
				.subscribe(System.out::println);

		// Print values from intNumbersFluxWithException and when errors
		// happen, replace with a fallback sequence of -1 and -2
		ReactorResource.intNumbersFluxWithException().onErrorResume(err -> Flux.just(-1, -2))
				.subscribe(System.out::println);

		System.out.println("Press a key to end");
		System.in.read();

	}

}
