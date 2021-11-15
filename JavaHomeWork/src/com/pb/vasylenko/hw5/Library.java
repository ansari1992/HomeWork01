package com.pb.vasylenko.hw5;


import java.util.ArrayList;

public class Library {
    public static void main(String[] args) {

        ArrayList<Book> libraryBooks = new ArrayList<>();
        ArrayList<Reader> readers = new ArrayList<>();

        //Initializing books
        Book first = new Book("FirstBook", "FirstAuthor", 1989);
        Book second = new Book("SecondBook", "SecondAuthor", 1875);
        Book third = new Book("ThirdBook", "ThirdAuthor", 2011);

        //Initializing readers
        Reader firstReader = new Reader("FirstReader", 1, "FirstFaculty",
                "2005-05-05", "0-95-025-04-01");
        Reader secondReader = new Reader("SecondReader", 2, "SecondFaculty",
                "2005-05-06", "0-96-025-04-01");
        Reader thirdReader = new Reader("ThirdReader", 3, "SecondFaculty",
                "2005-05-07", "0-97-025-04-01");

        libraryBooks.add(first);
        libraryBooks.add(second);
        libraryBooks.add(third);

        readers.add(firstReader);
        readers.add(secondReader);
        readers.add(thirdReader);

        System.out.println("Show all books:");
        showAllBooks(libraryBooks);
        System.out.println("\n");
        System.out.println("Show all readers:");
        showAllReaders(readers);
        System.out.println("\n");
        System.out.println("Show take books methods:");
        firstReader.takeBook(4);
        firstReader.takeBook(new String[]{"FirstBook", "SecondBook", "ThirdBook"});
        firstReader.takeBook(libraryBooks);
        System.out.println("\n");
        System.out.println("Show return books methods:");
        firstReader.returnBook(4);
        firstReader.returnBook(new String[]{"FirstBook", "SecondBook", "ThirdBook"});
        firstReader.returnBook(libraryBooks);

    }

    public static void showAllBooks(ArrayList<Book> books) {
        for (Book book : books) System.out.println(book.toString());
    }

    public static void showAllReaders(ArrayList<Reader> readers){
        for (Reader reader : readers) System.out.println(reader.toString());
    }
}
