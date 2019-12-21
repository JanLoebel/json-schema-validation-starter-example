package com.github.JanLoebel.jsonschemavalidationexample.rest;

import com.github.JanLoebel.jsonschemavalidationexample.model.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// This is just to show that you don't have to adapt anything in your controller.
@RestController
@RequestMapping("/books")
public class BookController {

    private final Set<BookDto> books = new HashSet<>();

    @GetMapping
    public ResponseEntity<Collection<BookDto>> getAllBooks() {
        return ResponseEntity.ok(this.books);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        this.books.add(bookDto);
        return ResponseEntity.ok(bookDto);
    }

}
