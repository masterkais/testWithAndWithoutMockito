package fr.spark.pfe.test_doubles;


import fr.spark.pfe.mock.dao.BookRepository;
import fr.spark.pfe.mock.entites.Book;
import fr.spark.pfe.mock.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class MockTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookService bookService;
    @Test
    public  void demoMockWithoutMockito() {
        BookRepositoryMock bookRepository = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepository);
        Book book = new Book();
        book.setBookId("id1");
        book.setDigital(true);
        book.setPrice(500);
        book.setPublishedDate(LocalDate.now());
        bookService.addBook(book);
bookRepository.verify(book,1);
    }

    @Test
    public  void demoMockWithMockito() {
       bookService = new BookService(bookRepository);
        Book book = new Book();
        book.setBookId("id1");
        book.setDigital(true);
        book.setPrice(500);
        book.setPublishedDate(LocalDate.now());
        bookService.addBook(book);
        verify(bookRepository,times(1)).save(book);
    }
}
