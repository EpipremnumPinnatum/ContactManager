
package models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {

    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

   

    public Contact(String name,String phoneNumber,String birthDate) throws ParseException{

        if (name==null||name.isBlank()) {
            throw new IllegalArgumentException("Name can not be null or blank.");
        }
        this.name = name;
        
        if(phoneNumber==null||phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number can not be null or blank.");
        }
        if (phoneNumber.length()<5) {
            throw new IllegalArgumentException("Phone number can not have less than 5 digits.");
        }
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = toAge(birthDate);
        
    
        
        
    }

    public Contact(Contact originalContact){

        this.name = originalContact.getName();
        this.phoneNumber = originalContact.getPhoneNumber();
        this.birthDate = originalContact.getBirthDate();
        this.age = originalContact.getAge();
    }

    public void setName(String name) {
        
        if (name==null||name.isBlank()) {
            throw new IllegalArgumentException("Name can not be null or blank.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        
        if(phoneNumber==null||phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number can not be null or blank.");
        }
        if (phoneNumber.length()<5) {
            throw new IllegalArgumentException("Phone number can not have less than 5 digits.");
        }
        
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setAge(int birthdDate){

        this.age = birthdDate;

    }

    public int getAge() {
        return age;

    }

    public void setBirthDate(String birthDate) throws ParseException{
        
        this.birthDate = birthDate;
    
        setAge(toAge(birthDate));
        
        
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int toAge(String birthDate)throws ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);

        long ageInMilliseconds = new Date().getTime() - formatter.parse(birthDate).getTime();

        return (int)(TimeUnit.MILLISECONDS.toDays(ageInMilliseconds)/365);

    }

    public String toString(){

        return "Name: " + getName()+ "\n" +
        "Phone number: " + getPhoneNumber() + "\n" +
        "Birth Date: " + getBirthDate() + "\n" +
        "Age: " + getAge() + " year(s) old\n\n"; 

    }
    
    
}

