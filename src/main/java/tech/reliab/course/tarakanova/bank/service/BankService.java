package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.tarakanova.bank.entity.Bank;
import tech.reliab.course.tarakanova.bank.entity.BankAtm;
import tech.reliab.course.tarakanova.bank.entity.BankOffice;
import tech.reliab.course.tarakanova.bank.entity.Client;
import tech.reliab.course.tarakanova.bank.entity.Employee;
import tech.reliab.course.tarakanova.bank.repository.BankAtmRepository;
import tech.reliab.course.tarakanova.bank.repository.BankRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankService {
    private static final Integer MAX_AMOUNT = 1000000;
    private final BankRepository bankRepository;
    private final BankOfficeService bankOfficeService;

    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    @Transactional
    public Bank get(UUID id) {
        return bankRepository.findById(id).orElse(null);
    }

    public Bank createBank() {
        var bank = new Bank();
        var rating = generateRating();
        bank.setName("bank");
        bank.setAmount(generateAmount());
        bank.setRating(rating);
        bank.setInterestRate(generateInterestRate(rating));
        return bankRepository.save(bank);
    }

    private BigDecimal generateAmount() {
        return BigDecimal.valueOf(Math.floor(Math.random() * MAX_AMOUNT));
    }

    private Double generateRating() {
        return Math.floor(Math.random() * 10000)/100;
    }

    private Double generateInterestRate(Double rating) {
        return 0.1 * rating;
    }

    public void addAtm(Bank bank, BankAtm atm) {
        bank.setAtmsCount(bank.getAtmsCount() + 1);
        bankRepository.save(bank);
    }

    public void addBankOffice(Bank bank, BankOffice bankOffice) {
        bank.setBankOfficesCount(bank.getBankOfficesCount() + 1);
        bankRepository.save(bank);
    }

    public void addEmployer(Bank bank, Employee employee) {
        bank.setEmployeesCount(bank.getEmployeesCount() + 1);
        bankRepository.save(bank);
    }

    public void addClient(Bank bank, Client client) {
        bank.setClientsCount(bank.getClientsCount() + 1);
        bankRepository.save(bank);
    }
}
