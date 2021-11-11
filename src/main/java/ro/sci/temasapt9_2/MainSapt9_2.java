package ro.sci.temasapt9_2;

import ro.sci.temasapt9_2.util.EmployeeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainSapt9_2 {

    static List<Employee> employeesList = new ArrayList<>();

    public static void main(String[] args)
    {
    String inFileName = "input.txt";
    int month = 5;
    String outFileName = "output.txt";


    sortedEmployees(employee -> employee.month == 05);




        Path fileIn = new File("../../../resources/input.txt").toPath();
        try (BufferedReader reader = Files.newBufferedReader(fileIn)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                employeesList.add(getEmployeeFromInputFile(line));
            }
        } catch (IOException x) {
            System.err.println("IOException: " + x);
        }
          System.out.println(employeesList.size() + " employees");
        System.out.println(employeesList);

        List<String> filteredEmployeesList = employeesList.stream().filter(employee -> employee.getMonth() == month).map(employee -> employee.getLastName()+" " +
                employee.getFirstName()).sorted().collect(Collectors.toList());

        Path fileOut = new File("../../../resources/output.txt").toPath();
        try {
            BufferedWriter writer = Files.newBufferedWriter(fileOut);

            for(String e : filteredEmployeesList){
                writer.write(e + "\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(filteredEmployeesList);
    }



    public static Employee getEmployeeFromInputFile(String line) {
        String [] tokens = line.split(",");
        if (tokens.length != 5) {
            return null;
        }
        int month = Integer.parseInt(tokens[3].trim());
        int day = Integer.parseInt(tokens[2].trim());
        int year = Integer.parseInt(tokens[4].trim());
        return new Employee(tokens[0], tokens[1], day, month, year);
    }


    public static void sortedEmployees (EmployeeSort employeeSort){
        for (Employee employee : employeesList){
            if (employeeSort.evaluate(employee)){
                System.out.println(employee);
            }
        }
    }



}

