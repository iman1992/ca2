
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CityInfo implements Serializable {
  
    @Id
    private String zipcode;
    private String city; 

    public CityInfo(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    public CityInfo() {
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
   
}
