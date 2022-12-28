package tech.reliab.course.tarakanova.bank.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.reliab.course.tarakanova.bank.repository.BankRepository;

@SpringBootTest
class BankServiceTest {
    @Autowired
    private BankService bankService;
    @Autowired
    private AtmService atmService;
    @Autowired
    private BankOfficeService bankOfficeService;
    @Autowired
    private EmployerService employerService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private PaymentAccountService paymentAccountService;
    @Autowired
    private CreditAccountService creditAccountService;

    @Test
    void test() {
        var bank = bankService.createBank("bank");
        var bankAtm = atmService.createAtm();
        var bankOffice = bankOfficeService.createBankOffice("bankOffice");
        var employer = employerService.createEmployer("employer");
        var client = clientService.createClient("client");
        var paymentAccount = paymentAccountService.createPaymentAccount();
        var creditAccount = creditAccountService.createCreditAccount();
    }
}