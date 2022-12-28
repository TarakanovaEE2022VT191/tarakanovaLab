package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.CreditAccount;
import tech.reliab.course.tarakanova.bank.repository.CreditAccountRepository;

@Service
@RequiredArgsConstructor
public class CreditAccountService {
    private final CreditAccountRepository creditAccountRepository;

    public CreditAccount createCreditAccount() {
        var credit = new CreditAccount();
        return creditAccountRepository.save(credit);
    }
}
