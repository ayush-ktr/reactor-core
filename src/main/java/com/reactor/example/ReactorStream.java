package com.reactor.example;

import java.util.List;
import java.util.Optional;

import com.reactor.util.ReactorResource;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorStream {

	public static void main(String[] args) throws Exception {
		
		Flux<Integer> numberFlux = ReactorResource.intNumbersFlux();

		// Non-Blocking, will collect all 10 elements and then return a new Mono
		Mono<List<Integer>> numberListMono = numberFlux.collectList();
		numberListMono.subscribe(System.out::println);
		
		// Blocking operation
		System.out.println(numberFlux.toStream().toList().size());
		
		
		// Blocking
		Optional<List<Integer>> result = numberListMono.blockOptional();
		System.out.println(result.get());
		
		
		System.in.read();
	}

}
