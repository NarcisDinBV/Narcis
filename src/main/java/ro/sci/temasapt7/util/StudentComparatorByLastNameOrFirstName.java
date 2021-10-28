package ro.sci.temasapt7.util;



import ro.sci.temasapt7.Student;

import java.util.Comparator;

public class StudentComparatorByLastNameOrFirstName implements Comparator<Student>{

public int compare(Student s1, Student s2) {
    if(s1.getLastName().compareToIgnoreCase(s2.getLastName()) == 0){
        return s1.getFirstName().compareToIgnoreCase(s2.getFirstName());
    } else {
        return s1.getLastName().compareToIgnoreCase(s2.getLastName());
    }
}

}
