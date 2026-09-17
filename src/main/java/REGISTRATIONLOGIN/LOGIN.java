package REGISTRATIONLOGIN;

import java.util.ArrayList;
import java.util.Scanner;

public class LOGIN extends REGISTRATION {

    public LOGIN(String username, String password, ArrayList<REGISTRATION> registeredUsers) {
        super(username, password);
        this.registeredUsers = registeredUsers;
    }
public LOGIN() {  
super("", ""); 
}
    public void attemptLogin(Scanner sc) {
        System.out.println("\nLOGIN");
        System.out.println("Enter your username: ");
        String loginUsername = sc.nextLine();
        System.out.println("Enter your password: ");
        String loginPassword = sc.nextLine();

        boolean found = false;
        for (REGISTRATION user : registeredUsers) {
            if (user.getUsername().equals(loginUsername) && user.getPassword().equals(loginPassword)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Login successful! Welcome, " + loginUsername + ".");
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
}