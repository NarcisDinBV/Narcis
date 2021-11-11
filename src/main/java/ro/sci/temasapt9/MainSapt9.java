package ro.sci.temasapt9;

import ro.sci.temasapt9.util.AthleteComparatorByTime;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MainSapt9 {


    public static void main(String[] args) {


        athleteShootingTime();
    }

    private static void athleteShootingTime() {

        List<Athlete> athletes = new ArrayList<>();

        Path fileIn = new File("../../../resources/ListOfBiathlonAthletes.csv").toPath();
        Athlete a;
        try (BufferedReader reader = Files.newBufferedReader(fileIn)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                a = (getAthletesFromCSVLine(line));
                System.out.println(a);
                athletes.add(a);
            }

        } catch (IOException x) {
            System.err.println("IOException: " + x);
        }
        System.out.println(athletes.size() + "athletes");
        System.out.println(athletes);

        List<String> filteredAthletesList = athletes.stream().sorted(new AthleteComparatorByTime()).map(athlete ->
                athlete.getName() + " " + athlete.getFinalTime()).collect(Collectors.toList());

        System.out.println(filteredAthletesList);
//        String Athlete ;a :for (String s : filteredAthletesList) {
//            System.out.println(filteredAthletesList);

//        }
//        {
//
//        }
    }

//    TreeSet<Athlete> AthletesByTime = new TreeSet<Athlete>(AthleteComparatorByTime);


    //        TreeSet<Student> AlbumListByName = new TreeSet<>(albumComparatorByAuthorOrName);
    //        AlbumListByName.addAll(Arrays.asList(a1, a2, a3));
    //
    //        for(Student a : AlbumListByName){
    //            LibraryUtil.setAlbumList(a);
    //        }



    public static Athlete getAthletesFromCSVLine(String line) {

        String [] tokens = line.split(",");
        if (tokens.length != 7){
            return null;
        }
        int id = Integer.parseInt(tokens[0].trim());
        int position = tokens[3].indexOf(":");
        int minutes = Integer.parseInt(tokens[3].substring(0,position));
        int seconds = Integer.parseInt(tokens[3].substring(position + 1));

        Duration InitialTime = Duration.ofSeconds((minutes * 60L) + seconds);

        return new Athlete(id,tokens[1],tokens[2],InitialTime, tokens[4], tokens[5], tokens[6]);
    }



}
