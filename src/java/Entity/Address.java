
package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Address implements Serializable {
    
    @Id
    private String street;
    private String additionalinfo;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private CityInfo city;

    public Address(String street, String additionalinfo, CityInfo city) {
        this.street = street;
        this.additionalinfo = additionalinfo;
        this.city = city;
    }

    public Address(String street, String additionalinfo) {
        this.street = street;
        this.additionalinfo = additionalinfo;
    }

    public Address() {
    }

    public CityInfo getCity() {
        return city;
    }

    public void setCity(CityInfo city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

}

