package com.ryandens.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
final class ExampleServiceQuarkusTest {

    @Inject
    ExampleService exampleService;


    @Test
    void name() {
        assertEquals(ExampleStrategy.ONE, exampleService.getStrategy());
    }
}
