package fr.spark.pfe.stub.dao;

import fr.spark.pfe.stub.entites.Book;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface BookRepository {
    void save(Book book);
    Book findBookById(String bookId);
    Book findBookByTitleAndPublishedDate(String title, LocalDate localDate);
    Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital);
    void saveAll(List<Book> books);
    Collection<Book> findAll();
    int findNumberOfBooks();
    List<Book> findNewBooks();
}