package fr.spark.pfe.mock.dao;

import fr.spark.pfe.mock.entites.Book;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);

}