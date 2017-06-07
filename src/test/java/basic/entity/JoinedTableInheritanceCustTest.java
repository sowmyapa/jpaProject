package basic.entity;

import org.apache.openjpa.persistence.OpenJPAEntityManager;
import org.apache.openjpa.persistence.OpenJPAPersistence;

import javax.persistence.*;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
public class JoinedTableInheritanceCustTest {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();

        userTransaction.begin();


        CustomerJoinedTable customer = new CustomerJoinedTable();
        customer.setFirstName("Charles");
        customer.setLastName("Dickens");
        customer.setCustType("RETAIL");
        customer.getAddress().setStreet("10 Downing Street");
        customer.getAddress().setAppt("1");
        customer.getAddress().setCity("NewYork");
        customer.getAddress().setZipCode("12345");
        em.persist(customer);

        OnlineCustomerJoinedTable onlineCust = new OnlineCustomerJoinedTable();
        onlineCust.setFirstName("Henry");
        onlineCust.setLastName("Ho");
        onlineCust.setCustType("ONLINE");
        onlineCust.getAddress().setStreet("1 Mission Street");
        onlineCust.getAddress().setAppt("111");
        onlineCust.getAddress().setCity("NewYork");
        onlineCust.getAddress().setZipCode("23456");
        onlineCust.setWebsite("www.amazon.com");
        em.persist(onlineCust);

        userTransaction.commit();

        OpenJPAEntityManager oem = OpenJPAPersistence.cast(em);
        Object objId=oem.getObjectId(customer);
        CustomerJoinedTable cust = oem.find(CustomerJoinedTable.class,objId);

        System.out.println("Retail Customer info: " + cust);

        objId=oem.getObjectId(onlineCust);
        OnlineCustomerJoinedTable ocust = oem.find(OnlineCustomerJoinedTable.class,objId);

        System.out.println("Online Customer info: " + ocust);


       /* Query query = em.createQuery("SELECT customer FROM ONLINECUSTOMER customer");
        List<OnlineCustomerSingleTable> list= query.getResultList();
        for( OnlineCustomerSingleTable o : list){
            System.out.println("Online customer :"+o);
        }

        Query query1 = em.createQuery("SELECT customer FROM CUSTOMERSINGLE customer");
        List<CustomerSingleTable> list1= query1.getResultList();
        for( CustomerSingleTable o : list1){
            System.out.println("Retail customer :"+o);
        }*/
        em.close();
        entityManagerFactory.close();

    }

}
