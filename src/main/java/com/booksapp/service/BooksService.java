package com.booksapp.service;

import com.booksapp.model.Book;

import java.util.List;

public interface BooksService {
    Book create(String title, String review, Integer grade);
    List<Book> listAll();
}
