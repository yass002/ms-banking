package tn.iteam.web;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.iteam.entities.BankAccount;
import tn.iteam.exceptions.AccountNotFoundException;
import tn.iteam.models.Customer;
import tn.iteam.proxies.CustomerRestClient;
import tn.iteam.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@RestController

public class BankAccountController {

    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    public BankAccountController(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> getAccounts(){
        List<BankAccount> accounts = accountRepository.findAll();
        if (accounts.isEmpty()){
            throw new AccountNotFoundException("No accounts found");
        }else
        return accounts ;
    }
    @GetMapping("/acc")
    public List<Customer> getAcc(){
        List<Customer> customers = customerRestClient.retrieveAllCustomer();
        if (customers.isEmpty()){
            throw new AccountNotFoundException("No accounts found");
        }else
            return customers;
    }
    @GetMapping("/accounts/{accountId}")
    public Optional<BankAccount> getAccounts(@PathVariable String accountId) {
        Optional<BankAccount> account = accountRepository.findById(accountId);
        Customer customer = customerRestClient.retrieveCustomer(account.get().getCustomerId());

        if (!account.isPresent()) {
            throw new AccountNotFoundException("Account with id " + accountId + " not found");
        }
        else {
            account.get().setCustomer(customer);
            return account;
        }

    }
}
