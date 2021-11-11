package ro.sci.temasapt9.util;

import ro.sci.temasapt9.Athlete;

public class Utils {

    public static int substringOccurrenceInString(String str, String findStr) {


        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
            }
            lastIndex++;
            lastIndex += findStr.length();
            if (lastIndex >= str.length()) {
                lastIndex = -1;
            }
        }

        System.out.println("The athlete has missed " + count + " times." + "     The final time can be seen below.");
        return count;
    }



}
