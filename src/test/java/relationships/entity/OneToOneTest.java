package relationships.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by sowmyaparameshwara on 6/6/17.
 */
public class OneToOneTest {

    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        Order order = new Order();
        order.setCustId(101);
        order.setOrderDesc("Order desc");
        order.setTotPrice(2000);
        order.setOrderDt(new Date());

        Invoice invoice = new Invoice();
        invoice.setAmountDue(100.00);
        invoice.setOrderCancelledDt(new Date());
        invoice.setOrderRaisedDt(new Date());
        invoice.setOrderSettledDt(new Date());
        invoice.setOrderId(order.getOrderId());
        invoice.setOrder(order);

        order.setInvoice(invoice);

        entityManager.persist(order);
        entityManager.persist(invoice);

        entityTransaction.commit();

        Order order1 = entityManager.find(Order.class, order.getOrderId());
        System.out.println("Invoice details for order  : " + order1.getInvoice());

        Invoice invoice1 = entityManager.find(Invoice.class,invoice.getInvoiceId());
        System.out.println("Order details for invoice  : " + invoice1.getOrder());

        entityManager.close();
        entityManagerFactory.close();

    }

}
