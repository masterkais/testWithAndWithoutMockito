import fr.spark.pfe.fake.dao.BookRepository;
import fr.spark.pfe.fake.entites.Book;
import fr.spark.pfe.fake.services.BookService;
import fr.spark.pfe.test_doubles.FakeBookRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BookServiceFakeTest {
@Test
    public void testSaveBook(){
    BookRepository bookRepository=new FakeBookRepository();
    BookService bookService=new BookService(bookRepository);
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
    public void testFakeSaveWithMockito(){
    BookRepository bookRepository =mock(BookRepository.class);
    BookService bookService = new BookService(bookRepository);
    Book book=new Book("1111","mockito in action",250,LocalDate.now());
    List<Book> bookList=new ArrayList<>();
    bookList.add(book);
    when(bookRepository.findAll()).thenReturn(bookList);
    assertEquals(1,bookService.findNumberOfBooks());
}
}
