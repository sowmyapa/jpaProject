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
public class CustomerCompositePrimaryKeyTest {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();

        userTransaction.begin();
        CustomerCompositePrimaryKey customer = new CustomerCompositePrimaryKey();
        customer.setFirstName("Alan");
        customer.setLastName("Harper");
        customer.setCustType("RETAIL");
        customer.setStreet("10 Downing Street");
        customer.setAppt("1");
        customer.setCity("NewYork");
        customer.setZipCode("12345");
        em.persist(customer);
        userTransaction.commit();

        OpenJPAEntityManager oem = OpenJPAPersistence.cast(em);
        Object objId=oem.getObjectId(customer);
        CustomerCompositePrimaryKey cust = oem.find(CustomerCompositePrimaryKey.class,objId);
        em.close();
        entityManagerFactory.close();
        System.out.println("Customer info: " + cust);

    }

}
