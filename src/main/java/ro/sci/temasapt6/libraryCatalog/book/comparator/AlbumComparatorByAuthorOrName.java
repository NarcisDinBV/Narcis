package ro.sci.temasapt6.libraryCatalog.book.comparator;

import ro.sci.temasapt6.libraryCatalog.book.Student;

import java.util.Comparator;

public class AlbumComparatorByAuthorOrName implements Comparator<Student> {

    @Override
    public int compare(Student a1, Student a2) {
        if (a1.getAuthor().compareToIgnoreCase(a2.getAuthor()) == 0) {
            return a1.getName().compareToIgnoreCase(a2.getName());
        } else {
            return a1.getAuthor().compareToIgnoreCase(a2.getAuthor());
        }
    }
}
