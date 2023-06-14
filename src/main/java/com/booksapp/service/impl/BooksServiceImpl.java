package com.booksapp.service.impl;

import com.booksapp.model.Book;
import com.booksapp.repository.BooksRepository;
import com.booksapp.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Book create(String title, String review, Integer grade) {
        return this.booksRepository.save(new Book(title, review, grade));
    }

    @Override
    public List<Book> listAll() {
        return this.booksRepository.findAll();
    }
}
