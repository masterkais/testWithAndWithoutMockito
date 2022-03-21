package fr.spark.pfe.test_doubles;

import fr.spark.pfe.spy.entites.Book;
import fr.spark.pfe.spy.dao.BookRepository;
import fr.spark.pfe.spy.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class SpyTest {
@Test
    public  void demoSpyWithoutMockito(){
    BookRepositorySpy bookRepository=new BookRepositorySpy();
    BookService bookService=new BookService(bookRepository);
    Book book=new Book();
    book.setBookId("id1");
    book.setDigital(true);
    book.setPrice(100);
    book.setPublishedDate(LocalDate.now());
    book.setPrice(100);
    bookService.addBook(book);
    Assertions.assertEquals(1,bookRepository.timesCalled());
Assertions.assertTrue(bookRepository.calledWith(book));
}
@Test
    public void demoSpyWithMockito(){
    BookRepository bookRepository= spy(BookRepository.class);
    BookService bookService=new BookService(bookRepository);
    Book book=new Book();
    book.setBookId("id1");
    book.setDigital(true);
    book.setPrice(100);
    book.setPublishedDate(LocalDate.now());
    book.setPrice(100);
    bookService.addBook(book);
    verify(bookRepository,times(1)).save(book);
}
@Test
    public void testSave(){
    BookRepository bookRepository= spy(BookRepository.class);
    BookService bookService=new BookService(bookRepository);
    Book book=new Book();
    book.setBookId("id1");
    book.setDigital(true);
    book.setPrice(100);
    book.setPublishedDate(LocalDate.now());
    book.setPrice(100);
    doNothing().when(bookRepository).save(book);
    bookService.addBook(book);
}

}
