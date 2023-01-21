package com.ensa.mscustomer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ensa.mscustomer.dao.CustomerRepository;
import com.ensa.mscustomer.entities.Customer;
import com.ensa.mscustomer.exceptions.EntityAlreadyExistsException;
import com.ensa.mscustomer.exceptions.EntityNotFoundException;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository repository;

	public CustomerServiceImpl(CustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Customer getCustomer(Long id) {
		
		if(repository.findById(id)==null) {
			throw new EntityNotFoundException("The customer doesn't exists !");
		}
		Customer customer=repository.findById(id).get();
		
		
		return customer;
	}

	@Override
	public Customer createCustomer(Customer customer) {

//		if(repository.findById(customer.getId())!=null) {
//			throw new EntityAlreadyExistsException("The customer has already this name");
//		}
		
			return	repository.save(customer);
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
	
		if(repository.findByFirstName(customer.getFirstName())==null) {
			throw new EntityNotFoundException("The customer doesn't exists");
		}
		
		Customer editCustomer=repository.findById(customer.getId()).get();
		         editCustomer.setFirstName(customer.getFirstName());
		         editCustomer.setLastName(customer.getLastName());
		         editCustomer.setAdress(customer.getAdress());
		         editCustomer.setEmail(customer.getEmail());
		         editCustomer.setCity(customer.getCity());
		         
		 return	repository.save(editCustomer);
		
	}

	@Override
	public List<Customer> getCustomerByName(String firstName) {
		
		if(repository.findByFirstName(firstName) == null) {
			throw new EntityNotFoundException("The customer doesn't exists !");
		}
		
		List<Customer> customers=repository.findByFirstName(firstName);
		
		return customers;
	}

	@Override
	public void deleteCustomer(Long id) {
		
		if(repository.findById(id)==null) {
			throw new EntityNotFoundException("The customer doesn't exists");
		}
		
		repository.deleteById(id);
		
	}

	@Override
	public List<Customer> listCustomers() {
	
		return repository.findAll();
	}

}
