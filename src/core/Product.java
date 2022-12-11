package core;

/**
 *
 * @author Jerome Loria
 */
public class Product {

    private String name;
    private double price;
    private int stock;

    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return name + "," + Double.toString(price) + "," + Integer.toString(stock) + "\n";
    }

    
    
    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}
