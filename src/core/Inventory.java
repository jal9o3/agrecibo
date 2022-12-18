package core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jerome Loria
 */
public class Inventory {

    private List<Product> products;
    private User manager;
    private List<User> allowed;

    public Inventory(List<Product> products, User manager, List<User> allowed) {
        this.products = products;
        this.manager = manager;
        this.allowed = allowed;
    }

    public User getManager() {
        return manager;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    
    @Override
    public String toString() {
        String result = "";
        
        result += this.products.size() + "\n";
        for (Product product : this.products) {
            // todo: replace with product.toString()
            result += product.toString();
        }
        result += manager.getFullname() + "\n";
        result += allowed.size() + "\n";
        for (User person : allowed) {
            result += person.getFullname() + "\n";
        }
        
        return result;
    }

    public List<Product> add(Product p) {
        this.products.add(p);
        return this.products;
    }

    public List<Product> delete(Product p) {
        // find index of product and remove element at that index
        int i = this.products.indexOf(p);
        this.products.remove(i);
        return this.products;
    }

    public Product find(String query) {
        // replace with binary search if sorting algorithm gets implemented

        for (Product product : this.products) {
            if (product.getName().equals(query)) {
                return product;
            }
        }
        // if product not found
        return null;

    }

    public List<User> allow(User u) {
        this.allowed.add(u);
        return this.allowed;
    }

    public static Inventory parseInventory(String s) {
        int i;
        String dataArr[] = s.split("\n");
        // get number of products
        int numOfProducts = Integer.parseInt(dataArr[0]);
        // load each product
        List<Product> products = new ArrayList<>();
        int currentLine = 1;
        for (i=0; i<numOfProducts; i++) {
            Product currentProduct = Product.parseProduct(dataArr[i+1]);
            products.add(currentProduct);
            currentLine++;
        }
        
        // get manager name
        String managerFullName[] = dataArr[currentLine].split(" ");
        String managerFirstName = managerFullName[0];
        String managerLastName = managerFullName[1];
        User manager = new User(managerFirstName, managerLastName);
        
        // get number of allowed users
        currentLine++;
        List<User> allowed = new ArrayList<>();
        int numOfAllowedUsers = Integer.parseInt(dataArr[currentLine]);
        currentLine++;
        // load each user
        for (int y=0; y<numOfAllowedUsers; y++) {
            String[] fullName = dataArr[currentLine].split(" ");
            String firstName = fullName[0];
            String lastName = fullName[1];
            User currentUser = new User(firstName, lastName);
            allowed.add(currentUser);
            currentLine++;
        }
        // load inventory      
        return new Inventory(products, manager, allowed);
    }

    
}
