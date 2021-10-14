package ro.sci.temasapt4.week4.vehicles;

import ro.sci.temasapt4.week4.vehicles.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week04Main {
    public static void main(String[] args)
    {
        int number = 5;
         Person john = new Person("John", "Doe", 24, true);
        System.out.println(john.toString());

        john.eat();

        System.out.println(john.toString());


        List<Integer> numbers =  new ArrayList<>();
        numbers.add(31);
        numbers.add(5);

        Collections.sort(numbers);
        System.out.println(numbers);

        Car myCar = new Car();
        myCar.start();
        System.out.println(myCar);

        Truck myTruck =  new Truck();
//        myTruck.start();
        myTruck.unload();
        System.out.println(myTruck);

        myCar = myTruck;
        myCar.start();

        Bus myBus = new Bus();
        Car[] autoPark = new Car[]{myCar, myBus, myTruck};
        for(Car currentCar: autoPark) {
            currentCar.start();
        }

        ElectricBus eBus =  new ElectricBus();
        System.out.println(eBus);

    }
}
