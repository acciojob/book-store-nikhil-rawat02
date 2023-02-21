package com.driver;

public class Book {
    
     private int id;

     private String name;

     private String genre;
     
     private String author;

     public Book(String name, String genre, String author){
          this.name = name;
          this.genre = genre;
          this.author = author;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getId() {
          return id;
     }

     public String getName() {
          return name;
     }

     public String getGenre() {
          return genre;
     }

     public String getAuthor() {
          return author;
     }
}
