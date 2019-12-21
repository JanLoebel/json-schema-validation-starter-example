package com.github.JanLoebel.jsonschemavalidationexample.rest;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Collection;

// We want to provide our own body on an error. This can/should be replaced with something like: `zalando-problem`.
public class JsonSchemaValidationErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final Collection<String> errors;

    public JsonSchemaValidationErrorResponse(int status, String error, Collection<String> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public Collection<String> getErrors() {
        return errors;
    }

}
