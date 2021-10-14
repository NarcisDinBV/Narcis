package ro.sci.temasapt6.libraryCatalog.book.comparator;

import ro.sci.temasapt6.libraryCatalog.book.Novel;

import java.util.Comparator;

public class NovelComparatorByPages implements Comparator<Novel>
{
    @Override
    public int compare(Novel n1, Novel n2) {
        int n1Page = n1.getNumberOfPages();
        int n2Page = n2.getNumberOfPages();

        return n1Page - n2Page;
    }
}
