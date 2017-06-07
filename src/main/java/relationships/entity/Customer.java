package relationships.entity;

import basic.entity.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by sowmyaparameshwara on 6/6/17.
 */
@Entity(name = "CUSTOMERRELATIONSHIP")
@Table(name = "CUSTOMERRELATIONSHIP")
public class Customer implements Serializable{

    @Id //signifies the primary key
    @Column(name = "CUST_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custId;

    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false,length = 50)
    private String lastName;

    @Column(name = "STREET")
    private String street;

    @OneToMany(mappedBy = "customer", targetEntity = Order.class,
    fetch = FetchType.EAGER)
    private Collection orders;

    @Embedded
    private Address address = new Address();

    @Column(name="EMAIL")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Collection getOrders() {
        return orders;
    }

    public void setOrders(Collection orders) {
        this.orders = orders;
    }

    // ToString()
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("   Customer Id : " + custId);
        sb.append("   First Name : " + firstName);
        sb.append("   Last Name : " + lastName);
        return sb.toString();
    }

}
