package com.booksapp.controller;
import com.booksapp.model.Book;
import com.booksapp.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<List<Book>>(booksRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return new ResponseEntity<Book>(booksRepository.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> viewBook(@PathVariable Long id){
        //return new ResponseEntity<Book>(booksRepository.findById(id).get(), HttpStatus.OK);
        return this.booksRepository.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id){
        booksRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return new ResponseEntity<Book>(booksRepository.save(book), HttpStatus.OK);
    }

}
