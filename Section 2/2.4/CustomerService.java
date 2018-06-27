package hello;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Customer customer) {
		entityManager.persist(customer);
		return customer.getId();
	}

	public Customer find(long id) {
		return entityManager.find(Customer.class, id);
	}
	
	public List<Customer> findAll() {
		Query query = entityManager.createNamedQuery(
				"query_find_all_customers", Customer.class);
		return query.getResultList();
	}
}