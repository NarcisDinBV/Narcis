package ro.sci.temasapt4.week4.vehicles;

public class Truck extends Car
{
    int loadCapacity;

    public void unload(){

    }

    @Override
    public void start() {
        System.out.println("Starting truck!");
        checkBrakePressure();
        super.start();
    }

    private void checkBrakePressure() {
    }
}
