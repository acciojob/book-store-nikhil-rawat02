package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") String iD){
        Book book = bookService.findBookById(iD);
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book> > findAll(){
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
    }
    @DeleteMapping("/delete-all-books")
    public void deleteAll(){
        bookService.deleteAllBooks();
    }
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String author){
        return new ResponseEntity<>(bookService.findBooksByAuthor(author),HttpStatus.CREATED);
    }
    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam("genre") String genre){
        return new ResponseEntity<>(bookService.findBooksByGenre(genre),HttpStatus.CREATED);
    }
}
