package com.example.bookservice;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookService {
    private final Map<Integer, Book> books = new ConcurrentHashMap<>();

    public Book createBook(Book book) {
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book payload is required");
        }
        if (book.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book id is required");
        }
        if (books.containsKey(book.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already exists");
        }
        books.put(book.getId(), book);
        return book;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(Integer id) {
        Book book = books.get(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        return book;
    }

    public Book updateBook(Integer id, Book updatedBook) {
        Book existing = books.get(id);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        if (updatedBook == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book payload is required");
        }
        existing.setBookname(updatedBook.getBookname());
        existing.setBookcount(updatedBook.getBookcount());
        books.put(id, existing);
        return existing;
    }

    public void deleteBook(Integer id) {
        if (!books.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        books.remove(id);
    }
}
