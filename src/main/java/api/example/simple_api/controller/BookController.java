package api.example.simple_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import api.example.simple_api.model.Book;
import api.example.simple_api.model.dto.CreateBookRequest;
import api.example.simple_api.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getAllBook();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 jika tidak ada
        }
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody CreateBookRequest book) {
        bookService.addBook(book);
        return new ResponseEntity<>("Book has been added successfully!", HttpStatus.CREATED);
    }
}