package lecture_02_OOPs.abstraction;


/*
Car Interface --> Act as an interface for Outside world to operate the car.
This interface tells 'WHAT' all it can do rather than 'HOW' it does that.
Since this is an interface we cannot directly create Objects of this.
We need to implement it first and then that child class will have the responsibility to provide implementation details of all the methods in the interface.

In our real world example of Car, imagine you sitting in the car and able to operate
the car (startEngine, accelerate, brake, turn) just by pressing or moving some pedals/buttons/stearing wheel etc.
You don't need to know how these things work, and also they are hidden under the hood.
This Interface 'Car' denotes that (pedals/buttons/stearing wheel etc.).
*/
interface Car {
    public void startEngine();
    public void stopEngine();
    public void accelerate();
    public void brake();
    public void shiftGear(int gear);
}


/*
This is a Concrete class (A class that provide implementation details of an interface/abstract class).
Now anyone can make an Object of 'SportsCar' and can assign it to 'Car' reference. (See main method for this)

In our real world example of Car, as you cannot have a real car by just having its body only (all these buttons or pedals).
You need to have the actual implementation of 'What' happens when we press these buttons. 'SportsCar' class denotes that actual implementation.

Hence, we can conclude, to denote a real world car in programming we created 2 classes.
One to denote all the user-interface like pedals, buttons etc. ('Car' interface).
And another one to denote the actual car with all the implementations of these buttons (SportsCar class).
 */
class SportsCar implements Car {

    public String brand;
    public String model;
    public Boolean isEngineOn = false;
    public int currentSpeed = 0;
    public int currentGear = 0;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void startEngine() {
        isEngineOn = true;
        System.out.println("SportsCar started");
    }

    @Override
    public void stopEngine() {
        isEngineOn = false;
        System.out.println("SportsCar stopped");
    }

    @Override
    public void accelerate() {
        if(!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is Off! Cannot accelerate. ");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + "km/h");
    }

    @Override
    public void brake() {
        currentSpeed -= 20;
        if(currentSpeed < 0) {
            currentSpeed = 0;
        }
        System.out.println(brand + " " + model + " : Braking to " + currentSpeed + "km/h");
    }

    @Override
    public void shiftGear(int gear) {
        if(!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is Off! Cannot Shift Gear. ");
            return;
        }
        currentGear = gear;
        System.out.println(brand + " " + model + " : Engine is On! Shift Gear. " + currentGear);
    }
}



public class Abstraction {
    static void main() {

        Car myCar = new SportsCar("Ford", "Mustang");

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
    }
}
