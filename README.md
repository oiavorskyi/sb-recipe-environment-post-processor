## Context
When creating a Spring Boot auto-configuration library that needs to
manipulate properties of other dependencies, such as Spring Cloud Stream or
Spring Cloud Sleuth, we can rely on the environment post-processing feature
of Spring Boot. This recipe demonstrates how to do it and how to test the 
implementation.
