package ro.sci.temasapt6.libraryCatalog.book;

import ro.sci.temasapt6.libraryCatalog.util.Generator;

import static ro.sci.temasapt6.libraryCatalog.book.LibraryUtil.albumList;

public class Album //extends Book
{
    private long bookId;
    private String name;
    private String author;
    private int numberOfPages;
    private PaperQuality paperQuality;

    public Album(String name, String author, int numberOfPages, PaperQuality paperQuality) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.paperQuality = paperQuality;
    }

        public static void addAlbum(String name, String author, int numberOfPages, PaperQuality paperQuality) {
        Album newNovel = new Album(name, author, numberOfPages, paperQuality);
        albumList.add(newNovel);
    }

    public long getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public PaperQuality getPaperQuality() {
        return paperQuality;
    }

    @Override
    public String toString() {
        return "Album{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", paperQuality=" + paperQuality +
                '}';
    }
}
