/*s
 * Click nbfs://nbhost/SeystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package REGISTRATIONLOGIN;
import java.util.ArrayList;
import java.util.Random; 
import java.util.Scanner; 
import java.io.FileWriter;
import java.io.IOException; 
/**
 *
 * @author Student
 */
public class Part2Messages { 
private static int totalMessages = 0; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      boolean loggedIn = true; // replace with your real login result
      int choice = 0;
      
      System.out.println("Welcome to QuickChat.");
      int sent = 0;
      System.out.println("How many messages do you want to enter? ");
      int maxMessages = Integer.parseInt(input.nextLine().trim());
      
      while (choice != 3) { 
          System.out.println("\n1) Send Messages");
          System.out.println("2) Show recently sent messages");
          
          System.out.println("3) Quit"); 
          
          System.out.println("Choose an option:"); 
          choice = Integer.parseInt(input.nextLine().trim());
           
          if (choice == 1) { 
              if (!loggedIn) { 
             
                  System.out.println("You must log in first");
              } else if (sent >= maxMessages) {  
                      System.out.println("You have reched your meassage limit.");
              } else { 
                      System.out.println("Enter message:");
                      
                      String text = input.nextLine();
                      sent++;
                      System.out.println("Message " + sent + " of " + maxMessages + " saved ");
              
                      } 
          
              } else if (choice == 2) { 
                  System.out.println("Coming soon."); 
                  } else if (choice == 3) { 
                      System.out.println("Goodbye.");
                  } else { 
                      System.out.println("Invaild option.");
                  }
      }
      
              }
          }
      
    

class Message { 
    private static int totalMessage = 0; 
            public static ArrayList<Message>
            sentMessages = new ArrayList<>();
            public static ArrayList<Message>
             storedMessages = new ArrayList<>();
            public static ArrayList<String>
              messagesHashes = new ArrayList<>();

            
            public static ArrayList<String> messagesIDs = new ArrayList<>();
            public static ArrayList<Message> disregardedMessages = new ArrayList<>();
                    
                    
            private String messageID;
            private int messageNumber;
            private String recipient;
            private String message;
            private String messageHash;
                    
                    public Message(int messageNumber, String recipient, String message) { 
                        
                        this.messageNumber = messageNumber;
                        this.recipient = recipient;
                        this.message = message;
                        
                        this.messageID = 
                                generateMessageID();
                        this.messageHash = 
                                createMessageHash();
                    } 
                    
                    private String generateMessageID() { 
                        
                        Random random = new Random();
                        long number = 1000000000L + (long)
                                (random.nextDouble()* 9000000000L);
                        return String.valueOf(number);
                        }
                    public boolean checkMessageID() {                    
                        return messageID.length() <= 10;
                        }
                    public String checkRecipientCell() {  
                      if (recipient.startsWith("+27") && recipient.length() <=12) {
                          return "Cell phone number successfully captured.";
                      }
                        return "Cell phone number incorrectly formatted or does not contain international code.";
                        }                           
                        public String createMessageHash() {  
                          String[] words = message.split(" "); 
                          String firstWord = words[0];
                          String lastWord = words[words.length - 1];
                         return (messageID.substring(0, 2)+ ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
                        } 
                        public String sentMessage() { 
                            
                            Scanner input = new Scanner(System.in);
                            System.out.println(""" 
                                               choose an option 
                                               1) Send Message
                                               2) Disregard Message 
                                               3) Store Message
                                               """);
                            
                            System.out.println("Enter choice: ");
                            int choice =
                                    Integer.parseInt(input.nextLine());
                            switch (choice) { 
                                case 1: 
                                        totalMessage++;
                                        sentMessages.add(this); 
                                        messagesIDs.add(messageID);
                                        messagesHashes.add(messageHash);
                                        
                                        return "Message successfully sent.";
                                        
                                case 2: 
                                        disregardedMessages.add(this);
                                        return "message disregarded."; 
                                        
                                case 3:
                                    storedMessages.add(this);
                                    messagesIDs.add(messageID);
                                    
                                    messagesHashes.add(messageHash);
                                   
                                    return "Message successfully stored."; 
                                    
                                default: 
                                    return "No valid option selected.";
                            }
                        }
                        public String printMessges() { 
                            return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + message;
                        }
                        public static int returnTotalMessages()
                        { 
                            return totalMessage;
                            }
                        public void storeMessage() { 
                            try { 
                                FileWriter writer = new 
        FileWriter( "storedMessages.json", true);
                                
                                writer.write(
                                        "{\n" + 
                                                "\"MessageID\":\"" + messageID + "\",\n" + 
                                                "\"MessageHash\":\"" + messageHash +"\",\n" + 
                                                "\"Recipient\":\"" + recipient + "\",\n" + 
                                                "\"Message\":\""+ message + "\"\n" + 
                                                "}\n\n"  
                                ); 
                                        writer.close(); 
                                        
                                        System.out.println("Message stored successfully.");
                            } catch (IOException e) { 
                                System.out.println("Error storing message.");
                            
                
}      
    System.out.println( "Error storing message.");
}
    public String getMessagesID() { 
        return messageID; 
        }
     public String getRecipient() { 
         return recipient;  
     } 
     public String getMessage() { 
         return message; 
     } 
     public String getMessageHash() { 
         return messageHash;
         }
} 

             
           
                                    
                            
                                                
                            
                                              
                                                
                    
