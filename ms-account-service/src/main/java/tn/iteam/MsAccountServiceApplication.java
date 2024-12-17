package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.BankAccount;
import tn.iteam.enums.AccountType;
import tn.iteam.repositories.AccountRepository;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAccountServiceApplication.class, args);
    }



    @Bean
    public CommandLineRunner run( AccountRepository accountRepository) {
        return args -> {
            List<BankAccount> bankAccount = List.of(
                    BankAccount.builder().accountId(UUID.randomUUID().toString()).balance(1000).currency("USD").type(AccountType.CURRENT).customerId(1L).build(),
                    BankAccount.builder().accountId(UUID.randomUUID().toString()).balance(2000).currency("USD").type(AccountType.SAVINGS).customerId(2L).build()
            );
            accountRepository.saveAll(bankAccount);
        };
    }
}
