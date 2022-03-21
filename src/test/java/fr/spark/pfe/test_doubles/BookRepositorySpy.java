package fr.spark.pfe.test_doubles;

import fr.spark.pfe.spy.dao.BookRepository;
import fr.spark.pfe.spy.entites.Book;

import java.util.Collection;

public class BookRepositorySpy  implements BookRepository {
    int saveCalled=0;
    Book lastAddedBook =null;
    public void save(Book book){
        saveCalled++;
        lastAddedBook=book;
    }

    @Override
    public int findNumberOfBooks() {
        return 0;
    }

    @Override
    public Collection<Book> findAll() {
        return null;
    }

    public int timesCalled(){
        return saveCalled;
    }
    public boolean calledWith(Book book){
        return lastAddedBook.equals(book);
    }
}
