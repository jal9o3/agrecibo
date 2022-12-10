package core;

import java.util.List;

/**
 *
 * @author Jerome Loria
 */
public class Inventory {

    private List<Product> products;
    private User manager;
    private List<User> allowed;

    Inventory(List products, User manager, List allowed) {
        this.products = products;
        this.manager = manager;
        this.allowed = allowed;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public List<User> getAllowed() {
        return allowed;
    }

    public void setAllowed(List<User> allowed) {
        this.allowed = allowed;
    }

    public void add(Product p) {
        ;
    }

    public void edit(Product p) {
        ;
    }

    public void delete(Product p) {
        ;
    }

    public Product search(Product p) {
        return p;
    }

    public void logIn(String username, String pass) {
        ;
    }

    public void saveChanges() {
        ;
    }

    public String generateSummary() {
        return new String();
    }

    public String generateReceipt() {
        return new String();
    }

}
