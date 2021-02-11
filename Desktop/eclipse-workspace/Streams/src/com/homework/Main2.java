package com.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

	public static void main(String[] args) {

		List<Cars> cars = new ArrayList<>(Arrays.asList(create("Toyota", 35), create("Wolksvagen", 12),
				create("Audi", 3), create("Mercedes", 5), create("BMW", 2), create("Opel", 6)));

		var oldCars = cars.stream().filter(c -> c.getAge() > 10).collect(Collectors.toList());

		printCars(oldCars);
	}

	private static void printCars(List<Cars> list) {
		for (var car : list) {
			System.out.println(car.getAge() + " " + car.getName());
		}
	}

	public static Cars create(String name, int age) {
		return new Cars(name, age);
	}
}