package fr.spark.pfe.test_doubles;

import fr.spark.pfe.stub.dao.BookRepository;
import fr.spark.pfe.stub.entites.Book;
import fr.spark.pfe.stub.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubTest {
    @Test
    public void demoStubWihoutMockito(){
        BookRepository bookRepository=new BookReposioryStub();
        BookService bookService=new BookService(bookRepository);
        List<Book> newBooksWithApplieidDiscount=bookService.getNewBooksWithAppliedDiscont(10,7);
        Assertions.assertEquals(1,newBooksWithApplieidDiscount.size());
    }
    @Test
    public void demoStubWithMockito(){
        BookRepository bookRepository=mock(BookRepository.class);
        BookService bookService=new BookService(bookRepository);
        Book book=new Book();
        book.setPrice(500);
        book.setBookId("1");
        List<Book> bookList=new ArrayList<>();
        bookList.add(book);
        when(bookRepository.findNewBooks()).thenReturn(bookList);
        List<Book> newBooksWithApplieidDiscount=bookService.getNewBooksWithAppliedDiscont(10,7);
        Assertions.assertEquals(1,newBooksWithApplieidDiscount.size());

    }
}
