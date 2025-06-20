package com.ryandens;

import com.ryandens.example.ExampleService;
import com.ryandens.example.ExampleStrategy;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestProfile(ExampleServiceQuarkusTest.TestConfiguration.class)
final class ExampleServiceQuarkusTest {

    @Inject
    ExampleService exampleService;


    @Test
    void name() {
        assertEquals(ExampleStrategy.TWO, exampleService.getStrategy());
    }

    public static final class TestConfiguration implements QuarkusTestProfile {
        @Override
        public Map<String, String> getConfigOverrides() {
            return Map.of(
                    "com.ryandens.strategy", "TWO"
            );
        }
    }
}
