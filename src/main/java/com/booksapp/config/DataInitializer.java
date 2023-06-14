package com.booksapp.config;

import com.booksapp.model.Book;
import com.booksapp.service.BooksService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {
    private final BooksService booksService;

    public DataInitializer(BooksService booksService) {
        this.booksService = booksService;
    }


    @PostConstruct
    public void initData() {
        this.booksService.create("Book1","Review1",1);
        this.booksService.create("Book2","Review2",2);
        this.booksService.create("Book3","Review3",3);
        this.booksService.create("Book4","Review4",4);
        this.booksService.create("Book5","Review5",5);
        List<Book> books = this.booksService.listAll();
    }

}
