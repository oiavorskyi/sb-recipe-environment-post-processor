package com.jugglinhats.bootrecipes.epp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test that environment post processor")
public class CustomEnvironmentPostProcessorTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(EnvironmentPostProcessorApplication.class))
            .withInitializer(context -> {
                // In production code the environment post-processor instances are loaded from META-INF/spring.factories
                // file and applied to the context in ConfigFileApplicationListener.onApplicationEnvironmentPreparedEvent
                // method. Here we need to do it explicitly as ApplicationContextRunner used in tests does not
                // trigger the ConfigFileApplicationListener invocation.
                new CustomEnvironmentPostProcessor().postProcessEnvironment(context.getEnvironment(), null);
            });

    @Test
    @DisplayName("adds new custom property to Spring context")
    void addsCustomPropertyToSpringContext() {
        contextRunner.run(context -> {
            var customProperty = context.getEnvironment()
                    .getProperty("custom.property");
            assertThat(customProperty).isEqualTo("custom.value");
        });
    }
}
