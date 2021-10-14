package ro.sci.temasapt4.week4.vehicles;

public class Bus extends Car
{
    int passengers;

    @Override
    public void start() {
        super.start();
        System.out.println("Starting bus!");

    }
}
