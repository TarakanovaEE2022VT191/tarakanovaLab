package tech.reliab.course.tarakanova.bank.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tech.reliab.course.tarakanova.bank.entity.Bank;
import tech.reliab.course.tarakanova.bank.entity.BankOffice;
import tech.reliab.course.tarakanova.bank.repository.BankRepository;

import java.util.List;

//@ActiveProfiles("test")
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

        var bank = createBank();
        System.out.println(bank);
    }

    private Bank createBank() {
        var bank = bankService.createBank();
        for (int i = 0; i < 3; i++) {
            var bankOffice = bankOfficeService.createBankOffice();
            var atm = atmService.createAtm();
            bankService.addBankOffice(bank, bankOffice);
            bankService.addAtm(bank, atm);
            atmService.addBank(bank, atm);
            atmService.addBankOffice(bankOffice, atm);
            bankOfficeService.addBank(bankOffice, bank);
            for (int j = 0; j < 5; j++) {
                var employee = employerService.createEmployer("name" + j);
                bankService.addEmployer(bank, employee);
                employerService.addBank(employee, bank, bankOffice);
                var client = clientService.createClient("client" + j);
                client.getBanks().add(bank);
                clientService.save(client);
                bankService.addClient(bank, client);
            }
        }
        return bankService.get(bank.getId());
    }
}