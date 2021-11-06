package com.pb.vasylenko.hw5;

import java.util.Objects;

public class Book {
    private String bookName;
    private String author;
    private int bookYear;

    public Book() {
    }

    public Book(String name, String author, int year) {
        this.bookName = name;
        this.author = author;
        this.bookYear = year;
    }

    public int getBookYear() {
        return bookYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookYear == book.bookYear && Objects.equals(bookName, book.bookName) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, author, bookYear);
    }

    @Override
    public String toString() {
        return bookName + "(" + author + " " + bookYear + ")";
    }
}
