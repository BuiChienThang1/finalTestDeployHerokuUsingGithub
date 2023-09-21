package murach.business;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String birthDate; 
    private String hear;
    private String contactBy;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        birthDate = null;
        hear="";
        contactBy="";
    }

    public User(String firstName, String lastName, String email, String birthDate, String hear, String contactBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.hear = hear;
        this.contactBy = contactBy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    
     public String getHear(){
        return hear;
    }
    public void setHear(String hear){
        this.hear = hear;
    }
    
      public String getContactBy(){
        return contactBy;
    }
    public void setContactBy(String contactBy){
        this.contactBy = contactBy;
    }
    
    
    
    
   
    
}
