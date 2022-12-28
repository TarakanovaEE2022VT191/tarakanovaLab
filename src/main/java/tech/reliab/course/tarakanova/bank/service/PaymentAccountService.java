package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.PaymentAccount;
import tech.reliab.course.tarakanova.bank.repository.PaymentAccountRepository;

@Service
@RequiredArgsConstructor
public class PaymentAccountService {
    private final PaymentAccountRepository paymentAccountRepository;

    public PaymentAccount createPaymentAccount() {
        var paymentAccount = new PaymentAccount();
        return paymentAccountRepository.save(paymentAccount);
    }
}
