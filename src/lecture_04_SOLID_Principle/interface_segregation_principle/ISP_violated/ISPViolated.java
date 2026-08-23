package lecture_04_SOLID_Principle.interface_segregation_principle.ISP_violated;

// Single interface for all shapes (Violates ISP)
interface Shape {
    public double area();
    public double volume();      // 2D shapes don't have volume!
}


// Square is a 2D shape but is forced to implement volume()
class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double volume() {      // Unnecessary method
        throw new UnsupportedOperationException("Volume not applicable for Square");
    }
}


// Rectangle is also a 2D shape but is forced to implement volume()
class Rectangle implements Shape {

    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double volume() {      // Unnecessary method
        throw new UnsupportedOperationException("Volume not applicable for Rectangle");
    }
}


// Cube is a 3D shape, so it actually has a volume
class Cube implements Shape {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}


public class ISPViolated {
    static void main() {

        Shape square = new Square(5);
        Shape rectangle = new Rectangle(5, 10);
        Shape cube = new Cube(3);

        System.out.println("Area of square: " + square.area());
        System.out.println("Area of rectangle: " + rectangle.area());
        System.out.println("Area of cube: " + cube.area());
        System.out.println("Volume of cube: " + cube.volume());

        // System.out.println("Volume of square: " + square.volume());
        // System.out.println("Volume of rectangle: " + rectangle.volume());

        try {
            System.out.println("Volume of square: " + square.volume());
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
