package ro.sci.temasapt6.libraryCatalog.book;

import ro.sci.temasapt6.libraryCatalog.util.Generator;

public class Book
{
    private long bookId;
    private String name;
    private String author;
    private int numberOfPages;

    protected Book(String name, String author, int numberOfPages) {
        this.bookId = Generator.getGeneratedLong();
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                 "bookId='" + Generator.getGeneratedLong()+ '\'' +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

}
