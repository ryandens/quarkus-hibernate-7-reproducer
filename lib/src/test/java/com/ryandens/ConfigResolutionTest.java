package com.ryandens;

import com.ryandens.example.ExampleService;
import com.ryandens.example.ExampleStrategy;
import io.quarkus.test.component.QuarkusComponentTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusComponentTest
final class ConfigResolutionTest {

    @Inject
    ExampleService exampleConfig;

    @Test
    void name() {
        assertEquals(ExampleStrategy.ONE, exampleConfig.getStrategy());
    }
}
