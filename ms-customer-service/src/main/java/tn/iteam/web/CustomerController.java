package tn.iteam.web;


import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.iteam.entities.Customer;
import tn.iteam.exception.CustomerNotFoundException;
import tn.iteam.repos.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {
    //private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customers/{id}")
    public Customer retrieveCustomer(@PathVariable Long id){
        log.info("Retrieving customer with id {}",id);
        return customerRepository.findById(id).orElseThrow(
                ()->new CustomerNotFoundException("Customer with "+id +" not found")
        );
    }


    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomer(){
        List<Customer> customers = customerRepository.findAll();
        if(customers.isEmpty()){
            throw new CustomerNotFoundException("No customer found");
        }
        return customers;
    }
}
