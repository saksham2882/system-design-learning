package lecture_04_SOLID_Principle.liskov_substitution_principle.LSP_rules.method_rules.post_conditions_rule;

// A Postcondition must be satisfied after a method is executed.
// Subclasses can strengthen the Postcondition but cannot weaken it.

class Car {
    protected int speed;

    public Car() {
        this.speed = 0;
    }

    public void accelerate() {
        System.out.println("Accelerating");
        speed += 20;
        System.out.println("Current speed: " + speed);
    }

    // PostCondition: Speed must reduce after brake
    public void brake() {
        System.out.println("Applying brakes...");
        speed -= 20;
        System.out.println("Current speed: " + speed);
    }
}


// Subclass can strengthen post condition - Does not violate LSP
class HybridCar extends Car {
    private int charge;

    public HybridCar() {
        super();
        this.charge = 0;
    }

    // PostCondition: Speed must reduce after brake
    // PostCondition: Charge must increase.
    @Override
    public void brake(){
        System.out.println("Applying brakes...");
        speed -= 20;
        charge += 10;
        System.out.println("Current speed: " + speed);
        System.out.println("Current charge: " + charge);
    }
}


public class PostCondition {
    static void main() {

        Car car = new HybridCar();
        car.accelerate();
        car.accelerate();
        car.brake();    // works fine: HybridCar reduces speed and also increases charge.

        // Client feels no difference in substituting Hybrid car in place of Car.
    }
}
