package basic.listener;

import basic.entity.Customer;

import javax.persistence.*;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
public class CustListener{

    public CustListener(){

    }

    @PreUpdate
    public void preUpdate(Customer cust) {
        System.out.println("In pre update");
    }
    @PostUpdate
    public void postUpdate(Customer cust) {
        System.out.println("In post update");
    }

    @PostLoad
    public void postLoad(Customer cust) {
        System.out.println("In post load");
    }

    @PrePersist
    public void prePersist(Customer cust) {
        System.out.println("In pre persist");
    }

    @PostPersist
    public void postPersist(Customer cust) {
        System.out.println("In post persist");
    }

    @PreRemove
    public void preRemove(Customer cust){
        System.out.println("In pre remove");
    }

    @PostRemove
    public void postRemove(Customer cust){
        System.out.println("In post remove");
    }
}