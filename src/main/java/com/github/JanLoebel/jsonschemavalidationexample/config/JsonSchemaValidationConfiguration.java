package com.github.JanLoebel.jsonschemavalidationexample.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.JanLoebel.jsonschemavalidation.advice.JsonValidationRequestBodyControllerAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * NOTE: This is optional! This just shows how you can modify the validation.
 */
@Configuration
public class JsonSchemaValidationConfiguration {

    @Bean
    public JsonValidationRequestBodyControllerAdvice JsonValidationRequestBodyControllerAdvice(ObjectMapper objectMapper) {
        // We construct a custom jsonSchemaProvider to configure the module.
        return new JsonValidationRequestBodyControllerAdvice(objectMapper, new MyCustomJsonSchemaProvider());
    }
}
