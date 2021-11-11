package ro.sci.temasapt9.util;

import ro.sci.temasapt9.Athlete;

import java.util.Comparator;

public class AthleteComparatorByTime implements Comparator<Athlete> {

    @Override
    public int compare(Athlete a1, Athlete a2) {
        return (int) (a1.getFinalTime().getSeconds() - a2.getFinalTime().getSeconds());
    }
}
