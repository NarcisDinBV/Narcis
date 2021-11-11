package ro.sci.temasapt9_2.util;

import ro.sci.temasapt9_2.Employee;

import java.util.Comparator;

public class EmployeeComparatorByName implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {

        if(e1.getLastName().compareToIgnoreCase(e2.getLastName()) == 0){
            return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
        } else {
            return e1.getLastName().compareToIgnoreCase(e2.getLastName());
        }
    }
}
