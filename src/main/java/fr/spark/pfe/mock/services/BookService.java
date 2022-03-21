package fr.spark.pfe.mock.services;

import fr.spark.pfe.mock.dao.BookRepository;
import fr.spark.pfe.mock.dao.EmailService;
import fr.spark.pfe.mock.entites.Book;

public class BookService {

    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
    }
  public void addBook(Book book) {
      if (book.getPrice() > 400) {
          bookRepository.save(book);
      }
  }
}