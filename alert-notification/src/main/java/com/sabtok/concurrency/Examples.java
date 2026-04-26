package com.sabtok.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class Examples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = newSingleThreadExecutor();

        Future<List<Integer>> future = executorService.submit(() -> {
            System.out.println("Thread: "+Thread.currentThread().getName());
            delay(1);
            return Arrays.asList(1,2,3,4);
        });

        List<Integer> list = future.get();
        System.out.println(list);

        executorService.shutdown();

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
      /*  completableFuture.thenRunAsync(()-> {
            System.out.println("HI");
            return;
        });*/
       // completableFuture.complete("dummy");
       // System.out.println("data: "+completableFuture.get());

        CompletableFuture.supplyAsync(() -> {
            return "Hi Hello";
        });
        System.out.println(completableFuture.get());
    }

    private static void delay(int i) {
        try {
            Thread.sleep(1*60*60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
