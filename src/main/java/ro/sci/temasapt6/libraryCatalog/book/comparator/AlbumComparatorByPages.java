package ro.sci.temasapt6.libraryCatalog.book.comparator;


import ro.sci.temasapt6.libraryCatalog.book.Album;

import java.util.Comparator;

public class AlbumComparatorByPages implements Comparator<Album>
{
    @Override
    public int compare(Album a1, Album a2)
    {
    int a1Page = a1.getNumberOfPages();
    int a2Page = a2.getNumberOfPages();

    return a1Page - a2Page;
    }


}
