package com.github.JanLoebel.jsonschemavalidationexample.model;

import com.github.JanLoebel.jsonschemavalidation.JsonSchemaValidation;

// Prefix of the schema location is configured in the "MyCustomJsonSchemaProvider".
@JsonSchemaValidation("book.json")
public class BookDto {

    private String title;

    private String author;

    // ....

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
