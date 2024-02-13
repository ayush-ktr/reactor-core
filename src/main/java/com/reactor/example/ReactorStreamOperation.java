package com.reactor.example;

import com.reactor.util.ReactorResource;

public class ReactorStreamOperation {

	public static void main(String[] args) throws Exception {

		// Print all values from intNumbersFlux that's greater than 5
		ReactorResource.intNumbersFlux().filter(e -> e > 5).subscribe(e -> System.out.println(e));

		// Print 10 times each value from intNumbersFlux that's greater than 5
		ReactorResource.intNumbersFlux().filter(e -> e > 5).map(e -> e * 10).subscribe(System.out::println);

		// Print 10 times each value from intNumbersFlux for the first 3 numbers emitted
		// that's greater than 5
		ReactorResource.intNumbersFlux().filter(e -> e > 5).map(e -> e * 10).take(3).subscribe(System.out::println);

		// Print each value from intNumbersFlux that's greater than 20. Print -1 if no
		// elements are found
		ReactorResource.intNumbersFlux().filter(e -> e > 20).defaultIfEmpty(-1).subscribe(System.out::println);

		// Switch ints from intNumbersFlux to the right user from userFlux
		ReactorResource.intNumbersFlux().flatMap(n -> ReactorResource.userFlux().filter(e -> e.getId() == n).take(1))
				.subscribe(System.out::println);

		// Print only distinct numbers from intNumbersFluxWithRepeat
		ReactorResource.intNumbersFluxWithRepeat().distinct().subscribe(e -> System.out.println(e));

		// Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
		ReactorResource.intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(e -> System.out.println(e));

		System.out.println("Press a key to end");
		System.in.read();

	}

}
