package com.example.completablefuture;

import java.util.ArrayList;
import java.util.List;

/**
 * In this example, the only thread running is the
 * main thread. It sleeps for 2 seconds each time
 * the setRating() method is called
 */
public class RealLifeWithoutCompletableFutureExample {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		// creating a list of cars
		List<Car> cars = cars();

		Long cars_data_processing_start = System.currentTimeMillis();
		// setting the rating of each car
		cars.forEach(car -> {
			float rating = rating(car.manufacturerId);
			car.setRating(rating);
		});
		Long cars_data_processing_end = System.currentTimeMillis();

		// printing cars
		cars.forEach(System.out::println);

		long end = System.currentTimeMillis();

		System.out.println("The cars data processing to set its ratings took : " +
				(cars_data_processing_end - cars_data_processing_start) + " ms.");
		System.out.println("The program took " + (end - start) + " ms.");
	}

	static float rating(int manufacturer) {
		try {
			simulateDelay();
			System.out.println("Thread : " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(e);
		}

		switch (manufacturer) {
		case 2:
			return 4f;
		case 3:
			return 4.1f;
		case 7:
			return 4.2f;
		default:
			return 5f;
		}
	}

	static List<Car> cars() {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car(1, 3, "Fiesta", 2017));
		carList.add(new Car(2, 7, "Camry", 2014));
		carList.add(new Car(3, 2, "M2", 2008));
		return carList;
	}

	private static void simulateDelay() throws InterruptedException {
		Thread.sleep(2000);
	}
}

