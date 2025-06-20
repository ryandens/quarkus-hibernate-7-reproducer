package com.ryandens;

import io.quarkus.test.component.QuarkusComponentTest;
import io.quarkus.test.junit.util.QuarkusTestProfileAwareClassOrderer;
import org.junit.jupiter.api.ClassDescriptor;
import org.junit.jupiter.api.ClassOrdererContext;

import java.util.Optional;


public final class QuarkusComponentTestAwareClassOrderer extends QuarkusTestProfileAwareClassOrderer {

    @Override
    protected Optional<String> getCustomOrderKey(ClassDescriptor classDescriptor, ClassOrdererContext context, String secondaryOrderSuffix) {
        if (classDescriptor.isAnnotated(QuarkusComponentTest.class)) {
            return Optional.of("25_");
        }
        return super.getCustomOrderKey(classDescriptor, context, secondaryOrderSuffix);
    }
}
