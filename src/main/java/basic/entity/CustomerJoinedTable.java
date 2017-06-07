package basic.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
@Entity(name = "CUSTOMER") //Name of the basic.entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="CUST_TYPE", discriminatorType= DiscriminatorType.STRING,length=10)
@DiscriminatorValue("RETAIL")
public class CustomerJoinedTable implements Serializable{

    @Id
    @Column(name = "CUST_ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custId;

    @Column(name = "FIRST_NAME",nullable = false,length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Embedded
    private Address address = new Address();
    /*// By default column name is same as attribute name
    private String street;

    @Column(name = "APPT",nullable = false)
    private String appt;

    // By default column name is same as attribute name
    private String city;*/

    @Column(name = "ZIP_CODE",nullable = false)
    private String zipCode;

    @Column(name = "CUST_TYPE", length = 10)
    private String custType;

    @Version
    @Column(name="LAST_UPDATED_TIME")
    private Date updatedTime;

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /*  public String getStreet() {
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
    }*/

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
        sb.append("custId : " + custId);
        sb.append("   First Name : " + firstName);
        sb.append("   Last Name : " + lastName);
        sb.append("   customer type : " + custType);

        return sb.toString();
    }

}
