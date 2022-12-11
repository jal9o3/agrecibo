package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Jerome Loria
 */
public class User {

    private String username;
    private String passwordHash;
    private String passwordClue;
    
    User(String username) {
        this.username = username;
    }
    
    User() {
        this.username = new String();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordClue() {
        return passwordClue;
    }

    public void setPasswordClue(String passwordClue) {
        this.passwordClue = passwordClue;
    }
    
    

    static class UserFileExistsException extends Exception {

        public UserFileExistsException(String message) {
            super(message);
        }
    }

    public static boolean userExists(String username) {
        File userFilePath = new File("data/users/" + username);
        return userFilePath.exists() && !userFilePath.isDirectory();
    }

    public static void signUp(String username, String password, String passClue) throws NoSuchAlgorithmException, IOException, UserFileExistsException {

        String encodedPass = getHash(password);
        List<String> credentials = Arrays.asList(passClue, encodedPass);
        Inventory.makeDirIfNull("data/users");

        // if UserFile already exists throw exception
        // (conditional moved to another method for reusability)
        if (userExists(username)) {
            throw new UserFileExistsException("UserFile already exists!");
        } else {
            Path userFile = Paths.get("data", "users", username);
            Files.write(userFile, credentials, StandardCharsets.UTF_8);
        }
    }

    public static String getHash(String password) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encodedPass = Base64.getEncoder().encodeToString(hash);

        return encodedPass;
    }

    public static boolean logIn(String username, String password) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        if (userExists(username)) {
            FileInputStream fs = new FileInputStream("data/users/" + username);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            br.readLine();
            String storedHash = br.readLine();
            if (getHash(password).equals(storedHash)) {
                Path userFile = Paths.get("data", "users", "CURRENT_USER");
                List<String> toRecord = Arrays.asList(username);
                Files.write(userFile, toRecord, StandardCharsets.UTF_8);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void logOut() throws IOException {
        Path userFile = Paths.get("data", "users", "CURRENT_USER");
        Files.write(userFile, Arrays.asList(""), StandardCharsets.UTF_8);
    }

    public static String getCurrentUser() throws FileNotFoundException, IOException {
        FileInputStream fs = new FileInputStream("data/users/CURRENT_USER");
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        return br.readLine();
    }
}
