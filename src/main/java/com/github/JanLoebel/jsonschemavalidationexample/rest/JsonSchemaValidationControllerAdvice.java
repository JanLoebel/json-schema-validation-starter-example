package com.github.JanLoebel.jsonschemavalidationexample.rest;

import com.networknt.schema.ValidationMessage;
import com.github.JanLoebel.jsonschemavalidation.JsonSchemaValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collection;
import java.util.stream.Collectors;

// We want to modify the exception result to show multiple errors in the body.
// The JsonSchemaValidationErrorResponse should be replaced with something more standardized like `zalando-problem`.
// You could also provide a custom implementation of the method `handleValidationMessages`
// in the custom JsonSchemaProvider.
@ControllerAdvice
public class JsonSchemaValidationControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ JsonSchemaValidationException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        final JsonSchemaValidationException exception = (JsonSchemaValidationException) ex;

        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final String error = "Error while json schema validation";
        final Collection<String> errors = exception.getValidationMessages()
                .stream()
                .map(ValidationMessage::toString)
                .collect(Collectors.toList());

        return handleExceptionInternal(ex, new JsonSchemaValidationErrorResponse(status.value(), error, errors),
                new HttpHeaders(), status, request);
    }
}

