package fr.spark.pfe.fake.services;

import fr.spark.pfe.fake.dao.BookRepository;
import fr.spark.pfe.fake.dao.EmailService;
import fr.spark.pfe.fake.entites.Book;
import fr.spark.pfe.request.BookRequest;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
    }
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void addBook(BookRequest bookRequest) {
//		if(bookRequest.getPrice() <= 500){
//			return;
//		}
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }

    public void updatePrice(String bookId, int updatedPrice){
        if(bookId == null) {
            return;
        }
        Book book = bookRepository.findBookById(bookId);
//		if(book.getPrice() == updatedPrice){
//			return;
//		}
        book.setPrice(updatedPrice);
        bookRepository.save(book);
    }
    public  int findNumberOfBooks(){

        return bookRepository.findAll().size();
    }
}