package lecture_02_OOPs.polymorphism;

// Base Car class
abstract class Car1 {

    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public Car1(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }

    // Common methods for All cars.
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }

    public abstract void accelerate();             // Abstract method for Dynamic Polymorphism

    public abstract void accelerate(int speed);    // Abstract method for Static Polymorphism

    public abstract void brake();                  // Abstract method for Dynamic Polymorphism
}


class ManualCar2 extends Car1 {
    private int currentGear;

    public ManualCar2(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    // Specialized method for Manual Car
    public void shiftGear(int gear) {
        currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    // overriding and overloading accelerate at the same time.
    @Override
    public void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    // Overriding brake - Dynamic Polymorphism
    @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}


class ElectricCar1 extends Car1 {
    private int batteryLevel;

    public ElectricCar1(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    // specialized method for Electric Car
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " - " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println(brand + " - " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        batteryLevel -= 10;
        currentSpeed += 15;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h. Battery at " + batteryLevel + "%.");
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        batteryLevel -= 10 + speed;
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed +  " km/h. Battery at " + batteryLevel + "%.");
    }

    // Overriding brake - Dynamic Polymorphism
    @Override
    public void brake() {
        currentSpeed -= 15;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Regenerative braking! Speed is now " + currentSpeed + " km/h. Battery at " + batteryLevel + "%.");
    }
}


public class StaticAndDynamicPolymorphism {
    static void main() {

        Car1 manualCar = new ManualCar2("Ford", "Mustang");
        manualCar.startEngine();
        manualCar.accelerate();
        manualCar.accelerate();
        manualCar.brake();
        manualCar.stopEngine();

        System.out.println("----------------------");

        Car1 electricCar = new ElectricCar1("Tesla", "Model S");
        electricCar.startEngine();
        electricCar.accelerate();
        electricCar.accelerate();
        electricCar.brake();
        electricCar.stopEngine();
    }
}
