/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package REGISTRATIONLOGIN;
 import java.util.Scanner;
import java.util.ArrayList;   
/**
 *
 * @author Student
 */
public class REGISTRATION {

  private String username;
  private String password;
  protected ArrayList<REGISTRATION> registeredUsers = new ArrayList<>();
  
public REGISTRATION(String username, String password) { 
    this.username = username;
    this.password = password;
}
public String getUsername() { 
    return username;
}
public String getPassword() { 
    return password; 
}
public void register() { 
    registeredUsers.add(this);
    System.out.println("Registration successful for user: " + username);
}
public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    
    System.out.println("REGISTRATION");
    System.out.println("choose a username: ");
    String regUsername = sc.nextLine();
    System.out.println("Choose a password: ");
    String regPassword = sc.nextLine();
    
    REGISTRATION newUser = new REGISTRATION(regUsername, regPassword);
    newUser.register();
    // Hand off to login (the subclass) 
    LOGIN login = new LOGIN(); 
    login.attemptLogin(sc);
    
    sc.close(); 
            } 
}
            
