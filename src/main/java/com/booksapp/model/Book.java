package com.booksapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "review")
    private String review;

    @Column(name = "grade")
    private Integer grade;

    public Book(String title, String review, Integer grade){
        this.title = title;
        this.review = review;
        this.grade = grade;
    }

    public Book() {}
}


/*
BAZA H2 POLNENJE
INSERT INTO BOOK VALUES(5, 0, 'Best movie', 'Love, Rosie');
INSERT INTO BOOK VALUES(1, 1, 'The worst', 'Elevator');
INSERT INTO BOOK VALUES(2, 2, 'meh', 'Titanic');
 */