package ro.sci;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please insert the integer number that you want to check if it is prime or composite number!");
        Scanner insertedNumber = new Scanner(System.in);

        int myNumber = insertedNumber.nextInt();
        boolean flag = false;
        for (int i = 2; i <= myNumber / 2; i++) {
            if (myNumber % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println("The number you have inserted( " + myNumber + " ) it is a prime number");
        else
            System.out.println("The number you have inserted( " + myNumber + " ) it is a composite number");
    }
}