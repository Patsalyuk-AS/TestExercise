package com.github.patsalyukas.test.thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FileCounter {

    private static Path dir = Paths.get("src", "main", "java", "com", "github", "patsalyukas", "test", "thread");

    public long computeTotalNumberOfLines() {
        long result = 0;
        try {
            result = executeCounters().stream()
                    .mapToLong(this::extractValueFromFuture)
                    .sum();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private <T> T extractValueFromFuture(Future<T> future) {
        T val = null;
        try {
            val = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

    private List<Future<Long>> executeCounters() throws IOException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<Long>> futures = service.invokeAll(getFileLineCounters());
        service.shutdown();
        return futures;
    }

    private List<Callable<Long>> getFileLineCounters() throws IOException {
        return Files.list(dir)
                .filter(Files::isRegularFile)
                .map(this::callablePrintingCounter)
                .collect(Collectors.toList());
    }


    private Callable<Long> callableCounter(Path p){
        return () -> Files.lines(p).count();
    }

    private Callable<Long> callablePrintingCounter(Path path) {
        return () -> {
            long count = Files.lines(path).count();
            System.out.printf("%s has %d lines %n", path, count);
            System.out.println(Thread.currentThread().getName());
            return count;
        };
    }

    public static void main(String[] args) {
        FileCounter fileCounter = new FileCounter();
        System.out.printf("Total number of lines: %d%n", fileCounter.computeTotalNumberOfLines());
    }

}
