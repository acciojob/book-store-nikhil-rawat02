package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
public class BookRepository {
    List<Book> bookList;
    int id;
    public BookRepository(){
        this.bookList = new ArrayList<>();
        this.id = 1;
    }


    public Book save(Book book){
        book.setId(id++);
        this.bookList.add(book);
        return book;
    }

    public Book findBookById(int iD){
        System.out.println(bookList.size());
        for(Book book: bookList){
            if(book.getId() == iD)return book;
        }
        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById( int id){
        int idx =0;
        for(int i =0; i < bookList.size(); i++){
            if(bookList.get(i).getId() == id){
                idx = i;
            }
        }
        bookList.remove(idx);
    }

    public void deleteAll(){
        bookList.clear();
    }

    public List<Book> findBooksByAuthor( String author){
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookList){
            if(book.getAuthor().equals(author))booksByAuthor.add(book);
        }
        return booksByAuthor;
    }

    public List<Book> findBooksByGenre( String genre){
        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : bookList){
            if(book.getGenre().equals(genre))booksByGenre.add(book);
        }
        return booksByGenre;
    }
}
