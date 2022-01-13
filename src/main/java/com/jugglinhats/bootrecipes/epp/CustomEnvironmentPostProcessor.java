package com.jugglinhats.bootrecipes.epp;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MapPropertySource source = new MapPropertySource("custom",
                Map.of("custom.property", "custom.value"));
        environment.getPropertySources().addLast(source);
    }
}
