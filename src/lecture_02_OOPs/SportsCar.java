package lecture_02_OOPs;

public class SportsCar implements Car {

    private String brand;
    private String model;
    private Boolean isEngineOn;
    private int currentSpeed;
    private int currentGear;
    private String color;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
        isEngineOn = false;
        currentSpeed = 0;
        currentGear = 0;   // neutral
        color = "RED";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Boolean getEngineOn() {
        return isEngineOn;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        // Apply Validation
        this.color = color;
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
