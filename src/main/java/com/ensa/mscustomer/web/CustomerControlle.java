package com.ensa.mscustomer.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.mscustomer.entities.Customer;
import com.ensa.mscustomer.services.CustomerService;
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerControlle {
	
	
	private CustomerService customerService;
	
	public CustomerControlle(CustomerService customerService) {
		
		this.customerService = customerService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Customer>> listCustomers(){
		return ResponseEntity.ok(customerService.listCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.getCustomer(id));
	}
	
	@PostMapping("/save")
	public  ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.createCustomer(customer));
	}
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.updateCustomer(customer));
	}
	@GetMapping("/name/{firstName}")
	public  ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String firstName) {
		return ResponseEntity.ok(customerService.getCustomerByName(firstName));
	}
	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}

}
