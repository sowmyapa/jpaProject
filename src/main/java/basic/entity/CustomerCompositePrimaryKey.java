package basic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
@Entity(name="CUSTOMERCOMPOSITE")
@IdClass(CustomerCompositePrimaryKey.CustomerId.class)
public class CustomerCompositePrimaryKey  implements Serializable {


    @Id
    @Column(name = "FIRST_NAME",nullable = false,length = 50)
    private String firstName;

    @Id
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    // By default column name is same as attribute name
    private String street;

    @Column(name = "APPT",nullable = false)
    private String appt;

    // By default column name is same as attribute name
    private String city;

    @Column(name = "ZIP_CODE",nullable = false)
    private String zipCode;

    @Column(name = "CUST_TYPE", length = 10)
    private String custType;

    @Version
    @Column(name="LAST_UPDATED_TIME")
    private Date updatedTime;

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

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    // ToString()
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("   First Name : " + firstName);
        sb.append("   Last Name : " + lastName);
        sb.append("   customer type : " + custType);

        return sb.toString();
    }

    public static class CustomerId{
        public String firstName;
        public String lastName;

        public CustomerId(){

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

        public boolean equals(Object obj) {
            if(obj instanceof CustomerId){
                CustomerId cObj = (CustomerId) obj;
                if(cObj.firstName==this.firstName && cObj.lastName==this.lastName){
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode(){
            return firstName.length()+lastName.length();
        }
    }

}
