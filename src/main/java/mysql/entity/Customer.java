package mysql.entity;
// Generated Jul 15, 2020 9:35:56 PM by Hibernate Tools 4.3.1


/**
 * Customer generated by hbm2java
 */

public class Customer  implements java.io.Serializable {

     private Integer id;
     private String firstName;
     private String lastName;
     private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }




}


