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

        System.out.println("End of the program");

        //System.out.println("The solution is " + solution);
    }

    public static int longNetworkProcess(int value) {
        try {
            Thread.sleep(10000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        return value * 10;
    }
}
