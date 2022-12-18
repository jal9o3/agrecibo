package core;

/**
 *
 * @author Jerome Loria
 */
public class User {
    
    String firstName, lastName, passwordHash;
    
    User(String firstName, String lastName, String passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
    }
    
    public User (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFullname() {
        return firstName + " " + lastName;
    }
    
    public static User create(String firstName, String lastName, String password) {
        return new User(firstName, lastName, Security.hash(password));
    }
}
