package basic.entity;

import javax.persistence.*;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
@Table(name="ONLINECUSTOMERJOINED")
@Entity(name = "ONLINECUSTOMERJOINED") //Name of the basic.entity
@DiscriminatorValue("ONLINE")
@PrimaryKeyJoinColumn(name="CUST_ID",referencedColumnName="CUST_ID")
public class OnlineCustomerJoinedTable extends CustomerJoinedTable {

    @Column(name = "WEBSITE", length = 100)
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
