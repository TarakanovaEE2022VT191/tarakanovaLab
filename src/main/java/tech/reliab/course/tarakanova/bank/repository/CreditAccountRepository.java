package tech.reliab.course.tarakanova.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.tarakanova.bank.entity.Bank;
import tech.reliab.course.tarakanova.bank.entity.CreditAccount;

import java.util.UUID;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, UUID> {
}
