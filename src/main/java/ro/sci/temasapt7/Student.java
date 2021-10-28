package ro.sci.temasapt7;

import java.time.LocalDate;



public class Student {
    long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private String CNP;


    public Student(long id, String firstName, String lastName, LocalDate birthDate, String gender, String CNP) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.CNP = CNP;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", CNP=" + CNP +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getCNP() {
        return CNP;
    }
}
