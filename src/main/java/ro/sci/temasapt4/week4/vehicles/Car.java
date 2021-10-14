package ro.sci.temasapt4.week4.vehicles;

import java.awt.*;

public class Car
{
    float fuelLevel;
    byte gear;
    float speed;
    Color color;
    Engine engine;


    public Car()
    {
        color = Color.BLACK;
        engine = new Engine();
    }

    /**
     * Starts the car
     */
    public void start(){
        System.out.println("Starting car!");
        checkSensors();
        this.engine.turnOn();
    }

    protected void checkSensors()
    {
    }


}
