package api.example.simple_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import api.example.simple_api.model.Book;
import api.example.simple_api.model.dto.CreateBookRequest;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private long id = 1L;

    public BookService() {
        this.books.add(new Book(id, "Laskar Pelangi", "Andrea Hirata", "Novel"));
    }

    public List<Book> getAllBook() {
        return this.books;
    }

    public Book getBookById(long id) {
        return this.books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void addBook(CreateBookRequest book) {
        id++;

        Book newBook = new Book(id, book.getTitle(), book.getAuthor(), book.getDescription());
        this.books.add(newBook);
    }
}
