package ro.sci.temasapt9;

import ro.sci.temasapt9.util.Utils;

import java.time.Duration;

public class Athlete {
    int id;
    String Name;
    String Country;
    Duration initialTime;
    String firstShootingResult;
    String secondShootingResult;
    String thirdShootingResult;
    Duration finalTime;


    public Athlete(int id, String name, String country, Duration initialTime, String firstShootingResult,
                   String secondShootingResult, String thirdShootingResult) {
        this.id = id;
        Name = name;
        Country = country;
        this.initialTime = initialTime;
        this.firstShootingResult = firstShootingResult;
        this.secondShootingResult = secondShootingResult;
        this.thirdShootingResult = thirdShootingResult;
        int missedshots = Utils.substringOccurrenceInString(firstShootingResult + secondShootingResult + thirdShootingResult, "o");
        this.finalTime = Duration.ofSeconds(initialTime.getSeconds() + (missedshots * 10L));
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", initialTime=" + initialTime +
                ", firstShootingResult='" + firstShootingResult + '\'' +
                ", secondShootingResult='" + secondShootingResult + '\'' +
                ", thirdShootingResult='" + thirdShootingResult + '\'' +
                ", finalTime=" + finalTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Duration getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(Duration initialTime) {
        this.initialTime = initialTime;
    }

    public String getFirstShootingResult() {
        return firstShootingResult;
    }

    public void setFirstShootingResult(String firstShootingResult) {
        this.firstShootingResult = firstShootingResult;
    }

    public String getSecondShootingResult() {
        return secondShootingResult;
    }

    public void setSecondShootingResult(String secondShootingResult) {
        this.secondShootingResult = secondShootingResult;
    }

    public String getThirdShootingResult() {
        return thirdShootingResult;
    }

    public void setThirdShootingResult(String thirdShootingResult) {
        this.thirdShootingResult = thirdShootingResult;
    }

    public Duration getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Duration finalTime) {
        this.finalTime = finalTime;
    }
}

