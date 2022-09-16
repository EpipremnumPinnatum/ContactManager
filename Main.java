import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.Contact;
import models.ContactManager;

public class Main {

    static ContactManager contactManager = new ContactManager();

    public static void main(String[] args) {
        
         try {
            Main.loadContacts("contacts.txt");
            System.out.println("Contacts loaded.\n\n");
            System.out.println(contactManager);
            
            Main.manageContacts();
         } catch (FileNotFoundException fileNotFoundExceptionInMain) {
            System.out.println(fileNotFoundExceptionInMain.getMessage());
            
         }finally{

            System.out.println("Process complete");
         }

        

       

       
       

      
    }

  

    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */
    static public void manageContacts (){
      Scanner scan = new Scanner(System.in);

      while (true) {
         System.out.println("Would you like to \n\t'a' add another contact\n\t'b' to remove a contact or\n\t'c' to end the program.");
         
         String userInput = scan.nextLine();
         
         if(userInput.equals("a")){
            System.out.println("\tName: ");
            String newContactName = scan.nextLine();
            System.out.println("\tPhone Number: ");
            String newContactPhoneNumber = scan.nextLine();
            System.out.println("\tBirth Date: ");
            String newContactBirthDate = scan.nextLine();

            if(newContactName.trim().equals("")||newContactName.equals(null)||newContactPhoneNumber.equals(null)||newContactPhoneNumber.trim().equals("")){
               System.out.println("\nThe input you provided is not valid. Registration failed.");
               continue;
            }
            if(newContactPhoneNumber.trim().length()<5){
               System.out.println("Phone number can not be less than 5 characters.");
               continue;
            }

            try {
               contactManager.addContact(new Contact(newContactName, newContactPhoneNumber, newContactBirthDate));
            } catch (ParseException parseExceptionInUserInput) {
               System.out.println(parseExceptionInUserInput.getMessage());
            }finally{
               System.out.println("\n\nUPDATED CONTACTS\n\n"+contactManager);
            } 
         }else if(userInput.equals("b")){
            System.out.println("\nWho would you like to remove?");
            String nameOfContactToDelete = scan.nextLine();
            
            if (nameOfContactToDelete.equals(null)||nameOfContactToDelete.trim().equals("")) {
               System.out.println("Name can not be null or blank");
               continue;
            }
            contactManager.removeContact(nameOfContactToDelete);
            System.out.println("\n\nUPDATED CONTACTS\n\n"+contactManager);

         }else{
            break;}
      }

      scan.close();

    }


    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     * @throws ParseException
     */

     static public void loadContacts(String fileName) throws FileNotFoundException{
        File readFile = new File(fileName);
        Scanner scan = new Scanner(readFile);
         
        while (scan.hasNextLine()) {
         
         
         try {
            
            contactManager.addContact(new Contact (scan.next(),scan.next(),scan.next()));
         } catch (ParseException parseExceptionInLoadContacts) {
            System.out.println(parseExceptionInLoadContacts.getMessage());
         }
         
                
        }
        scan.close();
     }

     
}
//Part 6 Task 3 