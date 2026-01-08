package api.example.simple_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.example.simple_api.model.Book;
import api.example.simple_api.model.dto.CreateBookRequest;
import api.example.simple_api.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBook();
    }
    
    @GetMapping("/{id}")
    public Book getBook(@PathVariable() Long id) {
        return bookService.getBookById(id);
    }
    

    @PostMapping
    public String createBook(@RequestBody CreateBookRequest book) {
        bookService.addBook(book);
        
        return "Book has been added successfully!";
    }
    
    
}
