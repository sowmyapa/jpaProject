package relationships.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SurveyTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//Find out how many products each customer has
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("testjpa");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("SELECT customer FROM CUSTOMERRELATIONSHIP customer");
		List<Customer> list= query.getResultList();
		
		for(Customer customer:list){
			List prodList = new ArrayList();
			List prodListCancelled = new ArrayList();
			if(customer.getOrders()!=null){
				for(Order allOrders: (List<Order>)customer.getOrders()){
					if(allOrders.getInvoice().getOrderCancelledDt() == null){
//						Find out how many products each customer has
						prodList.addAll(allOrders.getProductList());
						
						System.out.println("Customer " + customer.getFirstName() +" " +  customer.getLastName() +" has the following products :-" );
						for(int i=0;i<prodList.size();i++){
							System.out.println("Product[" + (Product)prodList.get(i) + " ]");
						}
					}else{
//						Find out how many products cancelled by each customer
						prodListCancelled.addAll(allOrders.getProductList());
					
						System.out.println("Products cancelled by the customer " + customer.getFirstName() +" " +  customer.getLastName() +" are :-" );
						for(int i=0;i<prodListCancelled.size();i++){
							System.out.println("Product[ " + (Product)prodListCancelled.get(i) + " ]");
						}
					}
				}
			}
			System.out.println("Customer " + customer.getFirstName() +" " +  customer.getLastName() +" has the following products :-" );
			for(int i=0;i<prodList.size();i++){
				System.out.println("Product[" + (Product)prodList.get(i) + " ]");
			}
			System.out.println("Products cancelled by the customer " + customer.getFirstName() +" " +  customer.getLastName() +" are :-" );
			for(int i=0;i<prodListCancelled.size();i++){
				System.out.println("Product[ " + (Product)prodListCancelled.get(i) + " ]");
			}
		}


		em.close();
		entityManagerFactory.close();
		
	}
	
}
