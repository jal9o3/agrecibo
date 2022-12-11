package core;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jerome Loria
 */
public class Inventory {

    private List<Product> products;
    private String manager;
    private List<String> allowed;

    Inventory() {
        this.products = new ArrayList<>();
        this.manager = new String();
        this.allowed = new ArrayList<>();
    }

    Inventory(List products, String manager, List allowed) {
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<String> getAllowed() {
        return allowed;
    }

    public void setAllowed(List<String> allowed) {
        this.allowed = allowed;
    }
    
    static class UserLacksPermissionsException extends Exception {
        public UserLacksPermissionsException(String message) {
            super(message);
        }
    }

    public void add(Product p) throws IOException, UserLacksPermissionsException {
        // check if current user is inventory manager or is an allowed user
        if (this.manager.equals(User.getCurrentUser()) 
                || this.allowed.contains(User.getCurrentUser())) {
        
            // write file details to data/inventory
            Path productFile = Paths.get("data", "inventory", p.getName());
            List<String> toRecord = Arrays.asList(
                    p.getName(), Double.toString(p.getPrice()), Integer.toString(p.getStock()));
            Files.write(productFile, toRecord, StandardCharsets.UTF_8);
        }
        else {
            throw new UserLacksPermissionsException("Current user has not been granted permissions!");
        }
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

    public void addAllowed(User user) {
        ;
    }

    public static Inventory loadInventory() throws IOException {
        // create new inventory instance
        // and set its manager to the current user
        Inventory inventory = new Inventory();
        return inventory;
    }

    public static void makeDirIfNull(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs(); // create necessary folders
        }
    }

}
