package relationships.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by sowmyaparameshwara on 6/6/17.
 */
@Entity(name="ORDERS")
public class Order implements Serializable{

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @Column(name = "CUST_ID")
    private long custId;

    @Column(name = "TOTAL_PRICE", precision = 2)
    private double totPrice;

    @Column(name = "OREDER_DESC")
    private String orderDesc;

    @Column(name = "ORDER_DATE")
    private Date orderDt;

    @OneToOne(optional = false,cascade = CascadeType.ALL,mappedBy = "order",
            targetEntity = Invoice.class)
    private Invoice invoice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CUST_ID",referencedColumnName = "CUST_ID")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "ORDER_DETAIL", joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID"),
    inverseJoinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = "PROD_ID"))
    private List<Product> productList;

    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public double getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totPrice = totPrice;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Date getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(Date orderDt) {
        this.orderDt = orderDt;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // ToString()
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("   Order id : " + orderId);
        sb.append("   invoiceid : " + getInvoice().getInvoiceId());
        sb.append("   Cust Id : " + custId);
        sb.append("   Order Date : " + orderDt);
        sb.append("   Product List : " + productList);
        return sb.toString();
    }

}
