package relationships.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by sowmyaparameshwara on 6/6/17.
 */
public class ManyToManyTest {

    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        Order order = new Order();
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

        Customer customer = new Customer();
        customer.setFirstName("Aryan");
        customer.setLastName("Khanna");
        customer.setStreet("A Street");
        customer.getAddress().setStreet("A Street");
        customer.getAddress().setZipCode("60616");
        customer.getAddress().setAppt("Prairie");
        customer.getAddress().setCity("Chicago");
        customer.setEmail("cjso");

        Collection collection = new ArrayList();
        collection.add(order);
        customer.setOrders(collection);




        entityManager.persist(customer);
        order.setCustId(customer.getCustId());
        order.setCustomer(customer);


        Product product = new Product();
        product.setOrderList((List<Order>) collection);
        product.setProdName("Product1");
        entityManager.persist(product);

        List<Product> productsList = new ArrayList();
        productsList.add(product);
        order.setProductList(productsList);

        entityManager.persist(order);
        entityManager.persist(invoice);
        entityTransaction.commit();

        Order order1 = entityManager.find(Order.class, order.getOrderId());
        System.out.println("PRODUCT details for order  : " + order1.getProductList());

        Product prod1 = entityManager.find(Product.class,product.getProdId());
        System.out.println("Order details for product  : " + prod1.getOrderList());

        entityManager.close();
        entityManagerFactory.close();

    }

}
