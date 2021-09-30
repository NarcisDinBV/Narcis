package ro.sci.temasapt4;

import java.util.Scanner;

public class Calculateprice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let us know the net price of your product. We will help you with the total price including VAT.");
        double basePrice = scanner.nextInt();

        System.out.println("Please insert the VAT value of your product.");
        double vat = scanner.nextInt();

        calculatePrice(basePrice, vat);
    }

    public static void calculatePrice(double basePrice, double vat) {
        System.out.println("Your total price, including VAT, is " + (basePrice * ((100 + vat) / 100)));
    }
}
