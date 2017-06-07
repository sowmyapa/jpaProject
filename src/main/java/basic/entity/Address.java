package basic.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
@Embeddable
public class Address implements Serializable {
    private String street;

    @Column(name = "APPT",nullable = false)
    private String appt;

    private String city;

    @Column(name = "ZIP_CODE",nullable = false)
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAppt() {
        return appt;
    }

    public void setAppt(String appt) {
        this.appt = appt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


}
