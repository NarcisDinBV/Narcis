package ro.sci.temasapt10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FestivalGate {

    boolean gateIsOpened = true;
    List<TicketType> tickets = Collections.synchronizedList(new ArrayList<>());

 //   public boolean isGateIsOpened() { return gateIsOpened;}

//    public void setGateIsOpened(boolean opened) {gateIsOpened = opened;}

    public  List<TicketType> getTickets() {
        return tickets;
    }

}
