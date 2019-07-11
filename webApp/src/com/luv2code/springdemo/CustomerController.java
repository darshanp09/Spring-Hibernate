package com.luv2code.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		
		// get the customer from DAO
		List<Customer> customer = customerDao.getCustomer();
		
		// add to the model
		model.addAttribute("customers",customer);
		
		return "list-customer";
	}

}
