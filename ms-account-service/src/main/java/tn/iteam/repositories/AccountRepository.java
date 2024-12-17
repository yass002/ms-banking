package tn.iteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.entities.BankAccount;

public interface AccountRepository extends JpaRepository<BankAccount, String> {
}
