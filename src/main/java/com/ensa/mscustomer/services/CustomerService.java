package com.ensa.mscustomer.services;

import java.util.List;

import com.ensa.mscustomer.entities.Customer;

public interface CustomerService {
	
	public List<Customer> listCustomers();
	public Customer getCustomer(Long id);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public List<Customer> getCustomerByName(String firstName);
	public void deleteCustomer(Long id);
}
