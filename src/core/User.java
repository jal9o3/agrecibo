package core;

import java.io.File;
import java.io.IOException;
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

    String username, passwordHash, passwordClue;

    static class UserFileExistsException extends Exception {

        public UserFileExistsException(String message) {
            super(message);
        }
    }

    public static void signUp(String username, String password, String passClue) throws NoSuchAlgorithmException, IOException, UserFileExistsException {

        String encodedPass = getHash(password);
        List<String> credentials = Arrays.asList(passClue, encodedPass);
        File directory = new File("data/users");
        if (!directory.exists()) {
            directory.mkdirs(); // create necessary folders
        }
        // if UserFile already exists throw exception
        File userFilePath = new File("data/users/" + username);

        if (userFilePath.exists() && !userFilePath.isDirectory()) {
            throw new UserFileExistsException("UserFile already exists!");
        }
        Path userFile = Paths.get("data", "users", username);
        Files.write(userFile, credentials, StandardCharsets.UTF_8);
    }

    public static String getHash(String password) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encodedPass = Base64.getEncoder().encodeToString(hash);

        return encodedPass;
    }
}
