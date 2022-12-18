package core;

/**
 *
 * @author Jerome Loria
 */
public class Product {

    private String name;
    private double price;
    private int stock;
    private String imageFile;
    private String category;
    private String description;

    Product(String name, double price, int stock, 
            String imageFile, String category, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.imageFile = imageFile;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + "," + Double.toString(price) + "," + Integer.toString(stock) 
                + "," + imageFile + "," + category + "," + description + "\n";
    }

    public static Product parseProduct(String s) {
        String productData[] = s.split(",");
        String productName = productData[0];
        double productPrice = Double.parseDouble(productData[1]);
        int productStock = Integer.parseInt(productData[2]);
        String imageFile = productData[3];
        String category = productData[4];
        String description = productData[5];
        
        return new Product(productName, productPrice, productStock, 
                imageFile, category, description);
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
