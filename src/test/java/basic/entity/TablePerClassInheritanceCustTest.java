package basic.entity;

import org.apache.openjpa.persistence.OpenJPAEntityManager;
import org.apache.openjpa.persistence.OpenJPAPersistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by sowmyaparameshwara on 6/5/17.
 */
public class TablePerClassInheritanceCustTest {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();

        userTransaction.begin();


        CustomerTablePerClass customer = new CustomerTablePerClass();
        customer.setFirstName("Charles1");
        customer.setLastName("Dickens1");
        customer.setCustType("RETAIL");
        customer.getAddress().setStreet("10 Downing Street");
        customer.getAddress().setAppt("1");
        customer.getAddress().setCity("NewYork");
        customer.getAddress().setZipCode("12345");
        em.persist(customer);

        OnlineCustomerTablePerClass onlineCust = new OnlineCustomerTablePerClass();
        onlineCust.setFirstName("Henry1");
        onlineCust.setLastName("Ho1");
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
        CustomerTablePerClass cust = oem.find(CustomerTablePerClass.class,objId);

        System.out.println("Retail Customer info: " + cust);

        objId=oem.getObjectId(onlineCust);
        OnlineCustomerTablePerClass ocust = oem.find(OnlineCustomerTablePerClass.class,objId);

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
