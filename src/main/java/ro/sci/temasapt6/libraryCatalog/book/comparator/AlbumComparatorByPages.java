package ro.sci.temasapt6.libraryCatalog.book.comparator;


import ro.sci.temasapt6.libraryCatalog.book.Student;

import java.util.Comparator;

public class AlbumComparatorByPages implements Comparator<Student>
{
    @Override
    public int compare(Student a1, Student a2)
    {
    int a1Page = a1.getNumberOfPages();
    int a2Page = a2.getNumberOfPages();

    return a1Page - a2Page;
    }


}
