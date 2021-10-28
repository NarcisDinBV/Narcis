package ro.sci.temasapt7;

import ro.sci.temasapt7.exception.AddNewStudentException;
import ro.sci.temasapt7.exception.InvalidCnpException;
import ro.sci.temasapt7.exception.StudentAgeException;
import ro.sci.temasapt7.util.StudentComparatorByLastNameOrFirstName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.logging.Logger;

public class StudentRepository {


    private static Logger logger = Logger.getLogger(StudentRepository.class.getName());

    long currentId = 0;

    private static ro.sci.temasapt7.util.StudentComparatorByLastNameOrFirstName studentComparatorByLastNameOrFirstName = new StudentComparatorByLastNameOrFirstName();

    static TreeSet<Student> studentListByName = new TreeSet<>(studentComparatorByLastNameOrFirstName);


    public Student addStudent(String firstName, String lastName, LocalDate dateOfBirth, String gender, String cnp)
            throws AddNewStudentException, StudentAgeException, InvalidCnpException {

        if (firstName == null || firstName.trim().isEmpty())  {
            throw new AddNewStudentException("Please insert your first Name!");
        }
        if (lastName == null  || lastName.trim().isEmpty()) {
            throw new AddNewStudentException("Please insert your last Name!");
        }
        if (dateOfBirth.isBefore(LocalDate.of(1900, 1, 1)) || dateOfBirth.isAfter(LocalDate.now().minusYears(18))) {
            throw new StudentAgeException("Your date of birth should be between 1900 and 18 years ago!");
        }

        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")
                && !gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            throw new AddNewStudentException("Please write your gender as: Male or Female!");
        }


        if (cnp == null || cnp.length() != 13) {
             throw new InvalidCnpException("cnp should be exactly 13 digits long");
             }
             char s = cnp.charAt(0);
        // Pattern pattern = Pattern.compile(".*[^0-9].*");
         //       return false;



        for (Student student : studentListByName) {
            if (Objects.equals(cnp, student.getCNP())) {
                throw new InvalidCnpException("A student with this CNP (" + cnp +") already exist in our data base. Please insert a new CNP");
            }
        }


        Student studentToBeAdded = new Student(studentListByName.size() + 1, firstName, lastName, dateOfBirth, gender, cnp);
        studentListByName.add(studentToBeAdded);
        return studentToBeAdded;
    }

    public Student addStudent(Student studentToBeAdded) throws AddNewStudentException {
        studentListByName.add(studentToBeAdded);
        return studentToBeAdded;
    }


    public List<Student> studentsToBeRemoved(String removedFirstName, String removedLastName, LocalDate removedAge, String removedCnp) {
        List<Student> studentsToBeRemoved = new ArrayList<>();
        for (Student student : studentListByName) {
            if (listOfStudentsToBeRemoved(removedFirstName, removedLastName, removedAge, removedCnp)) {
                studentsToBeRemoved.add(student);
            }
        }
        return studentsToBeRemoved;
    }

    private boolean listOfStudentsToBeRemoved(String removedFirstName, String removedLastName, LocalDate removedAge, String removedCnp) {
        return false;
    }




    public static void printStudentsList() {
        for (Student s : studentListByName) {
            System.out.println(s);
        }
        ;
    }

    public static TreeSet<Student> getStudentsList() {
        return studentListByName;
    }




    @Override
    public String toString() {
        return "StudentRepository{" +
                "currentId=" + currentId +
                '}';
    }
}
