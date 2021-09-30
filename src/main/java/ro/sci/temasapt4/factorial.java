package ro.sci.temasapt4;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {

        System.out.println("Please type in the number n, for which you want to calculate n!");
        Scanner insertedNumber = new Scanner(System.in);
        int scanner  = insertedNumber.nextInt();

        int i, factorial=1;
        for(i=1; i <= scanner; i++){
            factorial = factorial*i;
        }
        System.out.println("Factorial of "+scanner+" is: "+factorial);
    }
}


