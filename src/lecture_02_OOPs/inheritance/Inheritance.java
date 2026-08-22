package lecture_02_OOPs.inheritance;


/*
We know that real world Objects show inheritance relationship where we have parent object and child object.
child object have all the characters or behaviors that parent have plus some additional characters/behaviors.
Like all cars in real world have a brand, model etc. and can start, stop, accelerate etc.
But some specific cars like manual car have gear System while other specific cars like Electric cars have battery system.

We represent this scenario of real world in programming by creating a parent class and defining all the characters(variables) or behaviours(methods) that all cars have in parent class.
Then we create different child classes that inherits from this parent class and define only those characters and behaviors that are specific to them.
Although objects of these child classes can access or call parent class characters(variables) and behaviours(methods).
Hence providing code reusability.
*/
class Car {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }

    // Common methods for all cars
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}



class ManualCar extends Car {
    private int currentGear;       // specific to Manual Car.

    public ManualCar(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    // Specialized method for Manual Car
    public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }
}


class ElectricCar extends Car {
    private int batteryLevel;     // specific to Electric Car.

    public ElectricCar(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    // Specialized method for Electric Car
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }
}


public class Inheritance {
    static void main() {

        ManualCar manualCar = new ManualCar("Suzuki", "WagonR");
        manualCar.startEngine();
        manualCar.shiftGear(1);      // specific to manual car
        manualCar.accelerate();
        manualCar.brake();
        manualCar.stopEngine();

        System.out.println("===========================");

        ElectricCar electricCar = new ElectricCar("Tesla", "Model S");
        electricCar.chargeBattery();  // specific to electric car
        electricCar.startEngine();
        electricCar.brake();
        electricCar.stopEngine();
    }
}
