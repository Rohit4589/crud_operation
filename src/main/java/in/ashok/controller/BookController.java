package in.ashok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import in.ashok.Sservice;
import in.ashok.binding.Book_Details;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private Sservice service;

    @PostMapping("/book")
    public ResponseEntity<String> saveBook(@RequestBody Book_Details book) {
        String msg = service.upsertBook(book);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book_Details>> getAllBooks() {
        List<Book_Details> list = service.getAllBooks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<String> updateBook(@RequestBody Book_Details book) {
        String msg = service.updateBook(book);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer bookId) {
        String msg = service.deleteBook(bookId);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
