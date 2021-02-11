package com.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>(
				Arrays.asList(create("Ieva", 40), create("Ieva", 22), create("Marta", 29), create("Markus", 35),
						create("Ivars", 25), create("Miks", 31), create("Iveta", 51), create("Lauris", 49)));

		// each element in that list at some point will be "p" (can rename the p). it
		// will filter all the elements complying

		var list = persons.stream().filter(p -> p.getAge() > 30).collect(Collectors.toList());
		System.out.println("First filter:");
		printPersons(list);

		var personsWithNameContainingA = persons.stream()
				.filter(p -> p.getName().contains("a") || p.getName().contains("A")).collect(Collectors.toList());

		System.out.println();
		System.out.println("Second filter:");

		printPersons(personsWithNameContainingA);

		var personMarta = persons.stream().filter(p -> p.getName().equalsIgnoreCase("marta"))
				.collect(Collectors.toList());

		System.out.println();
		System.out.println("Third filter:");
		printPersons(personMarta);

		System.out.println();
		System.out.println("Fourth filter:");
		var marta = persons.stream().filter(p -> p.getName().equalsIgnoreCase("marta")).findFirst();
		if (marta.isPresent()) {
			var m = marta.get();
			System.out.println(m.getName() + " " + m.getAge());
		}

		System.out.println();
		System.out.println("Fifth filter:");
		var ieva = persons.stream().filter(p -> p.getName().equalsIgnoreCase("ieva") && p.getAge() > 30).findFirst();

		if (ieva.isPresent()) {
			System.out.println(ieva.get().getAge() + " " + ieva.get().getName());

			// or alternatively to fifth filter approach can use this method:
			// var ieva =result.get();
			// system.out.println(ieva.getAge() + " " + ieva.getName());

		}

	}

	private static void printPersons(List<Person> list) {
		for (var person : list) {
			System.out.println(person.getAge() + " " + person.getName());
		}
	}

	public static Person create(String name, int age) {
		return new Person(name, age);
	}
}
