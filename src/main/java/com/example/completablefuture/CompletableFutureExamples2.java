package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureExamples2 {
    public static void main(String[] args) {

        System.out.println("Beginning of the program");

        CompletableFuture.supplyAsync(new Supplier<Integer>() {

            @Override
            public Integer get() {
                return longNetworkProcess(5);
            }
        }).thenAccept(value -> System.out.println(value));

        sleep(5);
        System.out.println("End of the program");
    }

    public static int longNetworkProcess(int value) {
        sleep(3);

        return value * 10;
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
