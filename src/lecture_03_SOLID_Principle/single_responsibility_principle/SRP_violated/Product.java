package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_violated;

// Product class representing any item of any E-Commerce
public class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
