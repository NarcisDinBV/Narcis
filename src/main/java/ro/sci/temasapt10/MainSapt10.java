package ro.sci.temasapt10;

public class MainSapt10 {
    public static void main(String[] args) throws InterruptedException {

        FestivalGate gate = new FestivalGate();
        TicketType[] ticketType = new TicketType[1];
        FestivalAttendeeThread[] festivalAttendee =
                new FestivalAttendeeThread[1];
        Thread createAttendees = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    ticketType[0] = TicketType.randomTicketType();
                    festivalAttendee[0] = new FestivalAttendeeThread(ticketType[0], gate);
                    festivalAttendee[0].start();
                    try {
                        festivalAttendee[0].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate, createAttendees);

        statsThread.start();



        createAttendees.start();
    }
}