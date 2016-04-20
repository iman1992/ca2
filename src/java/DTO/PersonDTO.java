package DTO;

public class PersonDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String zipCode;
    private String city;

    public PersonDTO(long id, String firstName, String lastName, String email, String street, String zipCode, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public PersonDTO(String firstName, String lastName, String email, String street, String zipCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public PersonDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
