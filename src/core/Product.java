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

    public static Product parseProduct(String s) {
        String productData[] = s.split(",");
        String productName = productData[0];
        double productPrice = Double.parseDouble(productData[1]);
        int productStock = Integer.parseInt(productData[2]);
        
        return new Product(productName, productPrice, productStock);
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
