package tn.iteam.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iteam.entities.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {




}
