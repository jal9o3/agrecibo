package core;

import java.io.IOException;
import static java.lang.System.exit;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jerome Loria
 */
public class AgreciboCLI {

    public static void run(String args[]) {
        
        //todo: store inventory data files in data/inventory
        
        Scanner reader = new Scanner(System.in);
        // if there isn't already, create data/inventories
        // and/or a default inventory
        Inventory.makeDirIfNull("data/inventories/inventory");
        
        /**
         * AgreciboCLI signup *
         */
        if (args[0].equals("signup")) {
            // prompt for username
            System.out.print("Enter username: ");
            String username = reader.nextLine();
            // prompt for password
            System.out.print("Enter password: ");
            String password = reader.nextLine();
            // prompt for password clue
            System.out.print("Enter clue for password: ");
            String passClue = reader.nextLine();
            if (passClue.equals(password)) {
                System.out.println("Clue cannot be same as password!");
                reader.close();
                exit(0);
            }
            // ask for password confirmation
            System.out.print("Confirm password: ");
            String confirmation = reader.nextLine();
            // if successful, hash password
            if (confirmation.equals(password)) {
                try {
                    User.signUp(username, password, passClue);

                } catch (NoSuchAlgorithmException | IOException ex) {
                    Logger.getLogger(AgreciboCLI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (User.UserFileExistsException ex) {
                    System.out.println("Account " + username + " already exists.");
                    Logger.getLogger(AgreciboCLI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } // else, output 'failed to confirm password'
            else {
                System.out.println("Failed to confirm password.");
            }
        } else if (args[0].equals("login")) {

            String username = args[1];
            // prompt user password
            System.out.print("Enter password for " + username + ": ");
            String password = reader.nextLine();

            try {
                if (User.logIn(username, password)) {
                    System.out.println("Login Success!");
                } else {
                    System.out.println("Login Failed.");
                }
            } catch (IOException | NoSuchAlgorithmException ex) {
                Logger.getLogger(AgreciboCLI.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (args[0].equals("logout")) {
            try {
                User.logOut();
            } catch (IOException ex) {
                Logger.getLogger(AgreciboCLI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
