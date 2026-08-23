package lecture_04_SOLID_Principle.interface_segregation_principle.ISP_followed;

// Separate interface for 2D shapes
interface TwoDimensionalShape {
    public double area();
}

// Separate interface for 3D shapes
interface ThreeDimensionalShape {
    public double area();
    public double volume();
}


// Square implements only the 2D interface
class Square implements TwoDimensionalShape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}


// Rectangle implements only the 2D interface
class Rectangle implements TwoDimensionalShape {

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
}


// Cube implements the 3D interface
class Cube implements ThreeDimensionalShape {
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


public class ISPFollowed {
    static void main() {

        TwoDimensionalShape square = new Square(5);
        TwoDimensionalShape rectangle = new Rectangle(5, 10);
        ThreeDimensionalShape cube = new Cube(5);

        System.out.println("Area of square: " + square.area());
        System.out.println("Area of rectangle: " + rectangle.area());
        System.out.println("Area of cube: " + cube.area());

        System.out.println("Volume of cube is: " + cube.volume());

    }
}
