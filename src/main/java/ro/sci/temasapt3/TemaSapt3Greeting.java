package ro.sci.temasapt3;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Scanner;

public class TemaSapt3Greeting {

    public static void main(String[] args) {
        System.out.println("Welcome to you Java course! Please let us know your First Name!");
        Scanner insertedName = new Scanner(System.in);

        String name = insertedName.nextLine();
        name = name.trim();
        if (name.isEmpty()) {
            System.out.println("Hello, stranger! Get ready for the Java adventure!");
        } else {
            System.out.println("Hello, " + name + "! Get ready for the Java adventure!");
        }
    }

}