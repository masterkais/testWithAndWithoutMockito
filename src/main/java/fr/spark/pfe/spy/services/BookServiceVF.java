package fr.spark.pfe.spy.services;

import fr.spark.pfe.spy.dao.BookRepository;
import fr.spark.pfe.spy.dao.EmailService;
import fr.spark.pfe.spy.entites.Book;

import java.util.List;

public class BookServiceVF {

    private BookRepository bookRepository;
    public BookServiceVF(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public BookServiceVF(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public int findNumberOfBooks(){
        return bookRepository.findAll().size();
    }
}