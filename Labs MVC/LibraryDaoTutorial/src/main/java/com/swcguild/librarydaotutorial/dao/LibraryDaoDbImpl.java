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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class LibraryDaoDbImpl implements LibraryDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        //spring looks at the setter for the name
            this.jdbcTemplate = jdbcTemplate;        
    }
    
    //SQL statements for authors
    
    private static final String SQL_INSERT_AUTHOR =
            "INSERT INTO authors (first_name, last_name, street, city, state,zip,phone)"
            + "values(?,?,?,?,?,?,?";
    
    private static final String SQL_DELETE_AUTHOR = 
            "DELETE FROM authors where author_id = ?";
    
    private static final String SQL_UPDATE_AUTHOR =
            "UPDATE authors SET first_name = ?, last_name=?, city=?, state=?, "
            + "zip=?, phone=? where author_id=?";
    
    private static final String SQL_SELECT_AUTHOR =
            "SELECT * from authors WHERE author_id=?" ;
            
    private static final String SQL_SELECT_AUTHORS_BY_BOOK_ID =
            "SELECT au.author_id, au.first_name, au.last_name, au.street, au.city"
            + "au.state, au.zip, au.phone FROM authors AS au"
            + "join books_authors AS ba on au.author_id = ba.author_id"
            + "WHERE ba.book_id = ?";
    
    private static final String SQL_SELECT_ALL_AUTHORS =
            "SELECT * FROM authors";
    
    //Books and books_authors
    
    private  static final String SQL_INSERT_BOOK = 
            "INSERT INTO books(isbn, title, publisher_id, price, publish_date)"
            + "value (?,?,?,?,?)";
    
    private static final String SLQ_INSERT_BOOKS_AUTHORS =
            "INSERTS INTO books_authors (book_id, author_id) value(?,?)";
    
    private static final String SQL_DELETE_BOOK =
            "DELETE FROM books WHERE book_id=?";
    
    private static final String SQL_DELETE_BOOKS_AUTHORS = 
            "DELETE FROM books_authors WHERE book_id = ?";
    
    private static final String SQL_UPDATE_BOOK = 
            "UPDATE books SET isbn=?, title=?, publisher_id=?, price=?, "
            + "publish_date=? WHERE book_id=?" ;
    
    //finish later page 2 tuturial 5
    
    @Override
    public void addAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAuthor(int authorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Author getAuthorById(int authorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Author> getAuthorsByBookId(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Author> getAllAuthors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBook(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book getBookById(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getbooksByAuthorId(int authorId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByPublisherId(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getAllBooks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePublisher(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publisher getPublisherById(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publisher getPublisherByBookId(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publisher> getAllPublisher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
