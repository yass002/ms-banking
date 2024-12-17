package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Customer;
import tn.iteam.repos.CustomerRepository;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerServiceApplication.class, args);
		System.out.println("Customer Service Application Started");
	}


	@Bean
	public CommandLineRunner init(CustomerRepository customerRepository){
		return args ->{
			List<Customer> customers = List.of(
					new Customer(null,"Ahmed","Ben Ahmed","yy@gmail.com"),
					new Customer(null,"Mohamed","Ben Mohamed","mm@gmail.com"),
					new Customer(null,"Ali","Ben Ali","ali@gmail.com")
			);
			customerRepository.saveAll(customers);
			customerRepository.findAll().forEach(
					c-> c.getEmail()
			);
		};
	}
}
