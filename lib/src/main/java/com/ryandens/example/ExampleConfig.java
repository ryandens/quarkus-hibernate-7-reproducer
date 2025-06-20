package com.ryandens.example;


import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "com.ryandens")
public interface ExampleConfig {

    @WithDefault("ONE")
    ExampleStrategy strategy();
}
