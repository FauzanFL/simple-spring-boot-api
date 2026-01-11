package api.example.simple_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.example.simple_api.model.Book;
import api.example.simple_api.model.dto.CreateBookRequest;
import api.example.simple_api.repository.BookRepository;

@Service
public class BookService {

    // Inject Repository
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(CreateBookRequest request) {
        Book newBook = new Book();
        newBook.setTitle(request.title());
        newBook.setAuthor(request.author());
        newBook.setDescription(request.description());

        bookRepository.save(newBook);
    }
}