package models;

import java.util.ArrayList;

public class ContactManager {
    
    ArrayList<Contact> contacts;



    public ContactManager(){
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContact(int index){
        return new Contact(contacts.get(index));
    }

    public void setContact(int index, Contact inputContact) {
        this.contacts.set(index, new Contact(inputContact));
    }

    public void addContact(Contact inputContact){
        this.contacts.add(new Contact(inputContact));
    }

    public void removeContact(String contactName){

if (contacts.isEmpty()) {
    throw new IllegalStateException("Can not remove contacts from empty lists.");  
}


        for (int listIndex = 0; listIndex < this.contacts.size(); listIndex++) {
            
            if (contactName.equals(this.contacts.get(listIndex).getName()) ) {
                
                this.contacts.remove(listIndex);

            }
            
        }
    }


    public String toString(){

        String temp = "";

      for (int index = 0; index < this.contacts.size(); index++) {
        
        temp += this.contacts.get(index).toString();

      }

      temp += "\n\n";
      
        return temp;


    }


}
