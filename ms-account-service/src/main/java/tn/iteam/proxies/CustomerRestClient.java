package tn.iteam.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iteam.models.Customer;

import java.util.List;

@FeignClient(name = "CUSTOMER")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    Customer retrieveCustomer(@PathVariable Long id);

    @GetMapping("/api/customers")
    List<Customer> retrieveAllCustomer();
}
