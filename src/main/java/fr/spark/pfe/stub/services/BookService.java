package fr.spark.pfe.stub.services;

import fr.spark.pfe.request.BookRequest;
import fr.spark.pfe.stub.dao.BookRepository;
import fr.spark.pfe.stub.dao.EmailService;
import fr.spark.pfe.stub.entites.Book;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
    }
   public List<Book> getNewBooksWithAppliedDiscont(int discountRate,int days ){
      List<Book> newBOOks=bookRepository.findNewBooks();
      for(Book book: newBOOks){
          int price=book.getPrice();
          int newPrice=price-(discountRate*price/100);
          book.setPrice(newPrice);
      }
      return newBOOks;

   }
}