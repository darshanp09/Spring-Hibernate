package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomer() {
		
		// Get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  : from or.hirbernate.query // 
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
		
		// execute query and result the list 
		List<Customer> cRef = theQuery.getResultList();
		//return the result 
		return cRef;
	}
	
	

}
