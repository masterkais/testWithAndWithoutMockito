package fr.spark.pfe.test_doubles;

import fr.spark.pfe.fake.dao.BookRepository;
import fr.spark.pfe.fake.entites.Book;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeBookRepository implements BookRepository {
    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(), book);
    }

    public Collection<Book> findAll() {
        return bookStore.values();
    }

    @Override
    public int findNumberOfBooks() {
        return bookStore.size();
    }

    @Override
    public Book findBookById(String bookId) {
        return null;
    }

    @Override
    public Book findBookByTitleAndPublishedDate(String title, LocalDate localDate) {
        return null;
    }

    @Override
    public Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
        return null;
    }

    @Override
    public void saveAll(List<Book> books) {

    }
}