package basic.entity;

import basic.listener.CustListener;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/*
 * http://www.javaworld.com/article/2077817/java-se/understanding-jpa-part-1-the-object-oriented-paradigm-of-data-persistence.html
 * CUSTOMER ENTITY CLASS
 */
@EntityListeners({CustListener.class})
@Entity(name="CUSTOMER")
public class Customer implements Serializable {

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


