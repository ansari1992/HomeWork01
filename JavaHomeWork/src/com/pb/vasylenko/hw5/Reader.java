package com.pb.vasylenko.hw5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Reader {
    private String readerName;
    private int libCardNumber;
    private String faculty;
    private LocalDate dateOfBirth;
    private String telephoneNumber;

    public Reader() {
    }

    public Reader(String readerName, int libCardNumber, String faculty, String dateOfBirth, String telephoneNumber) {
        this.readerName = readerName;
        this.libCardNumber = libCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.telephoneNumber = telephoneNumber;
    }

    public String getReaderName() {
        return readerName;
    }

    public int getLibCardNumber() {
        return libCardNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public void setLibCardNumber(int libCardNumber) {
        this.libCardNumber = libCardNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void takeBook(int countBooks) {
        System.out.println(this.readerName + " take " + countBooks + " books");
    }

    public void takeBook(String[] booksNames) {
        StringBuilder str = new StringBuilder(this.readerName + " take: ");
        for (int i = 0; i < booksNames.length; i++) {
            if (i < booksNames.length - 1) {
                str.append(booksNames[i]).append(",");
            } else {
                str.append(booksNames[i]);
            }
        }
        System.out.println(str);
    }

    public void takeBook(ArrayList<Book> books) {
        StringBuilder str = new StringBuilder(this.readerName + " take: ");
        for (int i = 0; i < books.size(); i++) {
            if (i < books.size() - 1) {
                str.append(books.get(i)).append(",");
            } else {
                str.append(books.get(i));
            }
        }
        System.out.println(str);
    }

    public void returnBook(int countBooks) {
        System.out.println(this.readerName + " return " + countBooks + " books");
    }

    public void returnBook(String[] booksNames) {
        StringBuilder str = new StringBuilder(this.readerName + " return: ");
        for (int i = 0; i < booksNames.length; i++) {
            if (i < booksNames.length - 1) {
                str.append(booksNames[i]).append(",");
            } else {
                str.append(booksNames[i]);
            }
        }
        System.out.println(str);
    }

    public void returnBook(ArrayList<Book> books) {
        StringBuilder str = new StringBuilder(this.readerName + " return: ");
        for (int i = 0; i < books.size(); i++) {
            if (i < books.size() - 1) {
                str.append(books.get(i)).append(",");
            } else {
                str.append(books.get(i));
            }
        }
        System.out.println(str);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return libCardNumber == reader.libCardNumber && Objects.equals(readerName, reader.readerName) && Objects.equals(faculty, reader.faculty) && Objects.equals(dateOfBirth, reader.dateOfBirth) && Objects.equals(telephoneNumber, reader.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerName, libCardNumber, faculty, dateOfBirth, telephoneNumber);
    }

    @Override
    public String toString() {
        return "Name:'" + readerName + '\'' + "\n" +
                "Card number:" + libCardNumber + "\n" +
                "Faculty:'" + faculty + '\'' + "\n" +
                "Date of birth:" + dateOfBirth + "\n" +
                "Telephone number:'" + telephoneNumber + '\'';
    }
}
