package tn.iteam.entities;


import jakarta.persistence.*;
import lombok.*;
import tn.iteam.enums.AccountType;
import tn.iteam.models.Customer;

import java.time.LocalDate;


@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class BankAccount {
    @Id

    private String accountId;
    private double balance;
    private LocalDate creationDate;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;

    private Long customerId;

}
