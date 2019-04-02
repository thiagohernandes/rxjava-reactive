package com.reactive.asyncex;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/competable")
@EnableAsync
public class CompletableFutureController {
    private final TaskExecutor taskExecutor;
    public CompletableFutureController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }
    @GetMapping
    public CompletableFuture<String> hello() {
        return CompletableFuture.supplyAsync(() -> {
            randomDelay();
            return "Hello World, from Spring Boot 2!" + Math.random();
        }, taskExecutor);
    }
    private void randomDelay() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
