package lecture_02_OOPs;

public class Main {
    public static void main(String[] args) {

        SportsCar myCar = new SportsCar("Ford", "Mustang");

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();

//        myCar.currentSpeed = 500;     // Private Access Modifier

        System.out.println(myCar.getCurrentSpeed());
        System.out.println(myCar.getColor());
        myCar.setColor("BLACK");
        System.out.println(myCar.getColor());
    }
}
