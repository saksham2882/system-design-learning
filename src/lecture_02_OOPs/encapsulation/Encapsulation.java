package lecture_02_OOPs.encapsulation;


/*
Encapsulation says 2 things:
1. An Object's Characteristics and its behavior are encapsulated together within that Object.
2. All the characteristics or behaviors are not for everyone to access. Object should provide data security.

We follow above 2 points about Object of real world in programming by:
1. Creating a class that act as a blueprint for Object creation. Class contain all the characteristics (class variable) and behavior (class methods) in one block, encapsulating it together.
2. We introduce access modifiers (public, private, protected, default) etc. to provide data security to the class members.
*/
interface Car {
    public void startEngine();
    public void stopEngine();
    public void accelerate();
    public void brake();
    public void shiftGear(int gear);
}


class SportsCar implements Car {

    private String brand;
    private String model;
    private Boolean isEngineOn = false;
    private int currentSpeed = 0;
    private int currentGear = 0;
    private String color = "RED";

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        // Apply Validation
        this.color = color;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
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


public class Encapsulation {
    static void main() {

        SportsCar myCar = new SportsCar("Ford", "Mustang");

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();

        // setting arbitrary value to speed
        // myCar.currentSpeed = 500;

        System.out.println("Current speed of car: " + myCar);

        myCar.setColor("BLACK");
        System.out.println("Current color: " + myCar.getColor());
    }
}
