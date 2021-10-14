package ro.sci.temasapt6.libraryCatalog.book;

import ro.sci.temasapt6.libraryCatalog.util.Generator;

import static ro.sci.temasapt6.libraryCatalog.book.LibraryUtil.novelList;

public class Novel //extends Book
{
    private long bookId;
    private String name;
    private String author;
    private int numberOfPages;
    private NovelType novelType;

    public Novel(String name, String author, int numberOfPages, NovelType novelType) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.novelType = novelType;
//        novelList.add(this);
    }

    public static void addNovel(String name, String author, int numberOfPages, NovelType novelType) {
        Novel newNovel = new Novel(name, author, numberOfPages, novelType);
        novelList.add(newNovel);

    }



    //    public Novel(String name, String author, int numberOfPages, NovelType novelType) {
//        super(name, author, numberOfPages);
//    }


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

    public NovelType getNovelType() {
        return novelType;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "bookId=" + Generator.getGeneratedLong() +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", novelType=" + novelType +
                '}';
    }


}
