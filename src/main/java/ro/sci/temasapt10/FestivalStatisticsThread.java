package ro.sci.temasapt10;

public class FestivalStatisticsThread extends Thread {

    private final Thread createAttendees;
    private int NR_OF_FULL_PASSES;
    private int NR_OF_FULL_VIP_PASSES;
    private int NR_OF_FREE_PASSES;
    private int NR_OF_ONE_DAY_PASSES;
    private int NR_OF_ONE_DAY_VIP_PASSES;
    private int TOTAL_NUMBER_OF_ATTENDEES;

    private FestivalGate gate;


    public FestivalStatisticsThread(FestivalGate gate, Thread createAttendees) {
        this.gate = gate;
        this.createAttendees = createAttendees;
    }

    @Override
    public void run() {
       boolean gateShouldStillBeOpened = true;
       int totalAttendees;
        while (TOTAL_NUMBER_OF_ATTENDEES < 100 || gateShouldStillBeOpened)  {
            resetStats();
            calculateNumberOfEachTicketType();
            totalAttendees = calculateTotalNumberOfAttendees();
            displayStats();
            if (totalAttendees == 100){
                gateShouldStillBeOpened = false;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetStats() {
        NR_OF_FULL_PASSES = 0;
        NR_OF_FULL_VIP_PASSES = 0;
        NR_OF_FREE_PASSES = 0;
        NR_OF_ONE_DAY_PASSES = 0;
        NR_OF_ONE_DAY_VIP_PASSES = 0;
        TOTAL_NUMBER_OF_ATTENDEES = 0;
    }

    private void calculateNumberOfEachTicketType() {
        synchronized (this.gate.getTickets()) {
            for (TicketType ticketType : this.gate.getTickets()) {
                if (ticketType.equals(TicketType.FULL)) {
                    NR_OF_FULL_PASSES++;
                } else if (ticketType.equals(TicketType.FREE_PASS)) {
                    NR_OF_FREE_PASSES++;
                } else if (ticketType.equals(TicketType.FULL_VIP)) {
                    NR_OF_FULL_VIP_PASSES++;
                } else if (ticketType.equals(TicketType.ONE_DAY)) {
                    NR_OF_ONE_DAY_PASSES++;
                } else if (ticketType.equals(TicketType.ONE_DAY_VIP)) {
                    NR_OF_ONE_DAY_VIP_PASSES++;
                }
            }
        }
    }

    private int calculateTotalNumberOfAttendees() {

        return   TOTAL_NUMBER_OF_ATTENDEES +=
                NR_OF_FREE_PASSES +
                NR_OF_ONE_DAY_VIP_PASSES +
                NR_OF_FULL_PASSES +
                NR_OF_ONE_DAY_PASSES +
                NR_OF_FULL_VIP_PASSES;
    }

    private void displayStats() {
        System.out.println(
                TOTAL_NUMBER_OF_ATTENDEES + " attendees in total until now" + "\n" +
                NR_OF_FREE_PASSES + " attendees with FREE pass" + "\n" +
                NR_OF_ONE_DAY_PASSES + " attendees with ONE DAY pass" + "\n" +
                NR_OF_ONE_DAY_VIP_PASSES + " attendees with ONE DAY VIP pass" + "\n" +
                NR_OF_FULL_PASSES + " attendees with FULL pass" + "\n" +
                NR_OF_FULL_VIP_PASSES + " attendees with FULL VIP pass" + "\n"
        );
        System.out.println("After just 5 seconds: ------------------------------------------------");
    }
}
