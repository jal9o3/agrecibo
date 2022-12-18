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
    private String id;

    public Product(String name, double price, int stock, 
            String imageFile, String category, String description,
            String id) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.imageFile = imageFile;
        this.category = category;
        this.description = description;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + "," + Double.toString(price) + "," + Integer.toString(stock) 
                + "," + imageFile + "," + category + "," + description + "," 
                + id + "\n";
    }

    public static Product parseProduct(String s) {
        String productData[] = s.split(",");
        String productName = productData[0];
        double productPrice = Double.parseDouble(productData[1]);
        int productStock = Integer.parseInt(productData[2]);
        String imageFile = productData[3];
        String category = productData[4];
        String description = productData[5];
        String id = productData[6];
        
        return new Product(productName, productPrice, productStock, 
                imageFile, category, description, id);
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

    public String getImageFile() {
        return imageFile;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
    
    
}
