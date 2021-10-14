package ro.sci.temasapt6.libraryCatalog.book.comparator;



import ro.sci.temasapt6.libraryCatalog.book.Novel;

import java.util.Comparator;

public class NovelComparatorByAuthorOrName implements Comparator<Novel>

{
    @Override
    public int compare(Novel n1, Novel n2) {
        if (n1.getAuthor().compareToIgnoreCase(n2.getAuthor()) == 0) {
            return n1.getName().compareToIgnoreCase(n2.getName());
        } else {
            return n1.getAuthor().compareToIgnoreCase(n2.getAuthor());
        }
    }
}
