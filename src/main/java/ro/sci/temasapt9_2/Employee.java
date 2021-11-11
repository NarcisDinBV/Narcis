package ro.sci.temasapt9_2;

import java.time.LocalDate;

public class Employee {
    String firstName;
    String lastName;
    int dayOfBirth;
    int month;
    int yearOfBirth;

    public Employee(String firstName, String lastName, int dayOfBirth, int month, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.month = month;
        this.yearOfBirth = yearOfBirth;
    }

    public Employee(String token0, String token1, String token2, int month, String token3) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonthOfBirth(int month) {
        this.month = month;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", month=" + month +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
