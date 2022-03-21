package fr.spark.pfe.spy.dao;

import fr.spark.pfe.spy.entites.Book;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface BookRepository {
    void save(Book book);
    int findNumberOfBooks();
    Collection<Book> findAll();

}