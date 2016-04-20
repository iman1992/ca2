
package Entity;

import javax.persistence.Entity;

@Entity
public class Person extends InfoEntity {
    
    private String firstName; 
    private String lastName; 

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    public Person(String firstName, String lastName, String email, String street, String zipCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setEmail(email);
        CityInfo c = new CityInfo(zipCode, city);
        Address a = new Address(street, "", c);
        this.setAddress(a);
    }
    
    
    
    public Person() {
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
    
}
