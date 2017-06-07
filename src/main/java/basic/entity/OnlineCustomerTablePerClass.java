package basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
@Entity(name = "ONLINECUSTOMERPERCLASS")
public class OnlineCustomerTablePerClass extends CustomerTablePerClass {

    @Column(name = "WEBSITE", length = 100)
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
