package ro.sci.temasapt7;

import org.apache.commons.math3.FieldElement;
import ro.sci.temasapt7.exception.AddNewStudentException;
import ro.sci.temasapt7.exception.InvalidCnpException;
import ro.sci.temasapt7.exception.StudentAgeException;
import ro.sci.temasapt7.util.AgeCalculator;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ro.sci.temasapt7.StudentRepository.studentListByName;

public class MainSapt7 {


    static StudentRepository studentRegister = new StudentRepository();


    static {
        // must set before the Logger
        // loads logging.properties from the classpath
        try (InputStream is = MainSapt7.class.getClassLoader().
                getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Logger logger = Logger.getLogger(MainSapt7.class.getName());

    public static void main(String[] args) throws InvalidCnpException, AddNewStudentException, StudentAgeException {



        //create new students
        try {
            studentRegister.addStudent("", "Duta", LocalDate.of(2001, 5, 9), "MalE", "6030105030015");
        } catch (AddNewStudentException | StudentAgeException | InvalidCnpException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }

        try {
            studentRegister.addStudent("Narcis", "", LocalDate.of(2001, 5, 9), "MalE", "5010205030016");
        } catch (AddNewStudentException | StudentAgeException | InvalidCnpException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }

        try {
            studentRegister.addStudent("Narcis", "Duta", LocalDate.of(2009, 5, 9), "MalE", "5020205030017");
        } catch (AddNewStudentException | StudentAgeException | InvalidCnpException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }

        try {
            studentRegister.addStudent("Narcis", "Duta", LocalDate.of(2001, 5, 9), "Masculin", "5040209080014");
        } catch (AddNewStudentException | StudentAgeException | InvalidCnpException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }

        try {
            studentRegister.addStudent("Mircea", "Sofron", LocalDate.of(1999, 5, 7), "Female", "504");
        } catch (AddNewStudentException | StudentAgeException | InvalidCnpException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }

        studentRegister.addStudent("Mihaela", "Alexandrescu", LocalDate.of(2003, 1, 5), "F", "6050604080014");

        try {
            studentRegister.addStudent("Ioana", "Duta", LocalDate.of(2000, 5, 9), "Male", "6050604080014");
        } catch (AddNewStudentException | StudentAgeException | InvalidCnpException e) {
            logger.log(Level.SEVERE,e.getMessage());
        }

        studentRegister.addStudent("Narcis", "Dumitru", LocalDate.of(2000, 5, 9), "FEMALE", "6050609080014");
        studentRegister.addStudent("Ana", "Alexandrescu", LocalDate.of(2000, 8, 4), "MALE", "5050809080012");
        studentRegister.addStudent("Albert", "Marin", LocalDate.of(2002, 12, 31), "FEMALe", "6050709080014");
        studentRegister.addStudent("Ionel", "Nicolae", LocalDate.of(2001, 11, 11), "MALE", "5050603080012");


        StudentRepository.printStudentsList();

        System.out.println("Please write your First Name: ");
        Scanner firstName = new Scanner(System.in);
        String fN = firstName.nextLine();
        validateFirstName(fN);


        System.out.println("Please write your Last Name: ");
        Scanner lastName = new Scanner(System.in);
        String lN = lastName.nextLine();
        validateLastName(lN, "Please insert your last Name!");

        System.out.println("Please write your gender: MALE / FEMALE");
        Scanner gender = new Scanner(System.in);
        String gen = gender.nextLine();
        validateGender(gen);


        System.out.println("Please write your date of birth! First the year (for ex.2001)");
        Scanner yearOfBirth = new Scanner(System.in);
        int year = yearOfBirth.nextInt();

        System.out.println("month (from 1 to 12)");
        Scanner monthOfBirth = new Scanner(System.in);
        int month = monthOfBirth.nextInt();

        System.out.println("day (from 1 to 31)");
        Scanner dayOfBirth = new Scanner(System.in);
        int day = dayOfBirth.nextInt();
//
// - exceptia asta m-a batut :) -------------------------------------------------------------------------------------------------
//        LocalDate dateOfBirth = LocalDate.now();
//        if (dateOfBirth.isBefore(LocalDate.of(1900, 1, 1)) || dateOfBirth.isAfter(LocalDate.now().minusYears(18))) {
//            throw new StudentAgeException("Your date of birth should be between 1900 and 18 years ago!");
//        }

        System.out.println("Please let us know your CNP!");
        Scanner cnpInput = new Scanner(System.in);
        String cnp = cnpInput.nextLine();
        ValidateCNPasOnly13Digits(cnp);
        ValidateExistingStudentByCNP(cnp);

        Student s1 = new Student(studentListByName.size() + 1, fN, lN, LocalDate.of(year, month, day), gen, cnp);

        studentRegister.addStudent(s1);

        StudentRepository.printStudentsList();

        //   int birthDate = AgeCalculator.calculateAge((LocalDate.of(year, 01, 05)), LocalDate.now());
        System.out.println("The newly added student's age is " + AgeCalculator.calculateAge((LocalDate.of(year, month, day)), LocalDate.now()));


        System.out.println("//--------------------------------------------------------------");



  //      System.out.println(studentRegister.studentsToBeRemoved("Albert", "Marin", LocalDate.of(2002, 12, 31), "6050709080014"));

   List<Student> studentsToBeRemoved = studentRegister.studentsToBeRemoved("Albert", "Marin", LocalDate.of(2002, 12, 31), "6050709080014");

        System.out.println(studentsToBeRemoved);

    }

    private static void ValidateExistingStudentByCNP(String cnp) throws InvalidCnpException {
        for (Student student : studentListByName) {
            if (Objects.equals(cnp, student.getCNP())) {
                throw new InvalidCnpException("A student with this CNP (" + cnp +") already exist in our data base. Please insert a new CNP");
            }
        }
    }

    private static void ValidateCNPasOnly13Digits(String cnp) throws InvalidCnpException {
        String regex = ".*href=\"\".*[^0-9].*\".*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(cnp);
        if (m.matches()) {
            String urlStr = m.group(1);
        }
        if (cnp.length() != 13) {
            throw new InvalidCnpException("cnp should be exactly 13 digits long");
        }
        char s = cnp.charAt(0);
    }

    private static void validateGender(String gen) throws AddNewStudentException {
        if (!gen.equalsIgnoreCase("male") && !gen.equalsIgnoreCase("female")
                && !gen.equalsIgnoreCase("m") && !gen.equalsIgnoreCase("f")) {
            throw new AddNewStudentException("Please write your gender as: Male or Female!");
        }
    }

    private static void validateLastName(String lN, String s) throws AddNewStudentException {
        if (lN == null || lN.trim().isEmpty()) {
            throw new AddNewStudentException(s);
        }
    }

    private static void validateFirstName(String fN) throws AddNewStudentException {
        validateLastName(fN, "Please insert your first Name!");
    }


}
