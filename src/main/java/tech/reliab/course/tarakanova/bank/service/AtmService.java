package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.Bank;
import tech.reliab.course.tarakanova.bank.entity.BankAtm;
import tech.reliab.course.tarakanova.bank.entity.BankOffice;
import tech.reliab.course.tarakanova.bank.entity.Employee;
import tech.reliab.course.tarakanova.bank.repository.BankAtmRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AtmService {
    private final BankAtmRepository bankAtmRepository;

    public BankAtm createAtm() {
        var atm = new BankAtm();
        atm.setName("atm");
        atm.setMaintenanceCost(BigDecimal.valueOf(1000));
        return bankAtmRepository.save(atm);
    }

    public void save(BankAtm atm) {
        bankAtmRepository.save(atm);
    }

    public BankAtm addBank(Bank bank, BankAtm bankAtm) {
        bankAtm.setBank(bank);
        bankAtm.setAmount(bank.getAmount().divide(BigDecimal.valueOf(10)));
        return bankAtmRepository.save(bankAtm);
    }

    public BankAtm addBankOffice(BankOffice bankOffice, BankAtm bankAtm) {
        bankAtm.setAddress(bankOffice.getAddress());
        return bankAtmRepository.save(bankAtm);
    }

    public BankAtm addEmployer(Employee employee, BankAtm bankAtm) {
        bankAtm.setEmployer(employee);
        return bankAtmRepository.save(bankAtm);
    }
}
