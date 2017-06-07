package basic.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
@Entity(name = "ONLINECUSTOMER")
@DiscriminatorValue("ONLINE")
public class OnlineCustomerSingleTable extends CustomerSingleTable {

    @Column(name="WEBSITE",length = 100)
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    // ToString()
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("custId : " + getCustId());
        sb.append("   First Name : " + getFirstName());
        sb.append("   Last Name : " + getLastName());
        sb.append("   customer type : " + getCustType());
        sb.append("   customer website : "+website);

        return sb.toString();
    }
}
