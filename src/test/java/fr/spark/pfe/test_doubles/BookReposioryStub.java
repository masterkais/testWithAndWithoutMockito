package fr.spark.pfe.test_doubles;

import fr.spark.pfe.stub.dao.BookRepository;
import fr.spark.pfe.stub.entites.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookReposioryStub implements BookRepository {

    @Override
    public void save(Book book) {

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

    @Override
    public Collection<Book> findAll() {
        return null;
    }

    @Override
    public int findNumberOfBooks() {
        return 0;
    }

    @Override
    public List<Book> findNewBooks() {
        List<Book> newBooks= new ArrayList<>();
        Book book=new Book();
        book.setBookId("id1");
        book.setDigital(true);
        book.setPrice(100);
        book.setPublishedDate(LocalDate.now());
        book.setPrice(100);
        newBooks.add(book);
        return newBooks;
    }
}
