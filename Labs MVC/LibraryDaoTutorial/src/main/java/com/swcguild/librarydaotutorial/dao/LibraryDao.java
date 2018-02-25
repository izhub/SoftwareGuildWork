/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.librarydaotutorial.dao;

import com.swcguild.librarydaotutorial.model.Author;
import com.swcguild.librarydaotutorial.model.Book;
import com.swcguild.librarydaotutorial.model.Publisher;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface LibraryDao {
    
    public void addAuthor(Author author); //can add author anytime, doesn't have to have a book
    public void deleteAuthor(int authorId); // can't delete anytime, linked to books
    public void updateAuthor(Author author);
    public Author getAuthorById(int authorId);
    public List<Author> getAuthorsByBookId(int bookId);
    public List<Author> getAllAuthors();
    
    public void addBook(Book book);    //can't add anytime(need author/pub info)
    public void deleteBook(int bookId); // can delete anytime 
    public void updateBook(Book book);
    public Book getBookById(int bookId);
    public List<Book> getbooksByAuthorId(int authorId);
    public List<Book> getBooksByPublisherId(int publisherId);
    public List<Book> getAllBooks();
    
   
    public void addPublisher(Publisher publisher);  //can add publisher anytime
    public void deletePublisher(int publisherId);  // can't delete anytime (related to books)
    public void updatePublisher(Publisher publisher);
    public Publisher getPublisherById(int publisherId);
    public Publisher getPublisherByBookId(int bookId);
    public List<Publisher> getAllPublisher();
}
