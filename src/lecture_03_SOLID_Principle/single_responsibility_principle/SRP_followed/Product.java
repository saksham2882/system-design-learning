package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_followed;

// Product class representing any item of any E-Commerce
public class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
