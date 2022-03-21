package fr.spark.pfe.test_doubles;
import fr.spark.pfe.fake.dao.EmailService;
import fr.spark.pfe.fake.entites.Book;
import fr.spark.pfe.fake.services.BookService;
import fr.spark.pfe.fake.dao.BookRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DummyTest {
   @Test
   public void demoDummyWithoutMockito(){
       BookRepository bookRepository=  new FakeBookRepository();
       EmailService emailService=new DummyEmailService();
       BookService bookService=new BookService(bookRepository,emailService);
       Book book=new Book();
       book.setBookId("id1");
       book.setDigital(true);
       book.setPrice(100);
       book.setPublishedDate(LocalDate.now());
       book.setPrice(100);
       bookService.addBook(book);
       assertEquals(1,bookService.findNumberOfBooks());

   }
    @Test
    public void demoDummyWithMockito(){
        BookRepository bookRepository=  mock(BookRepository.class) ;
        //dummyTest
        EmailService emailService=mock(EmailService.class);
        BookService bookService=new BookService(bookRepository,emailService);
        Book book=new Book();
        book.setBookId("id1");
        book.setDigital(true);
        book.setPrice(100);
        book.setPublishedDate(LocalDate.now());
        book.setPrice(100);
        List<Book> bookList=new ArrayList<>();
       bookList.add(book);
       when(bookRepository.findAll()).thenReturn(bookList);
        assertEquals(1,bookService.findNumberOfBooks());

    }
}
