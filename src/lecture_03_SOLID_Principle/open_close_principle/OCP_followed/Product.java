package lecture_03_SOLID_Principle.open_close_principle.OCP_followed;


// Product class representing any item in E-Commerce.
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
                ", price=$" + price +
                '}';
    }
}
