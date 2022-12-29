package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.Bank;
import tech.reliab.course.tarakanova.bank.entity.BankAtm;
import tech.reliab.course.tarakanova.bank.entity.BankOffice;
import tech.reliab.course.tarakanova.bank.repository.BankOfficeRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BankOfficeService {
    private final BankOfficeRepository bankOfficeRepository;

    public BankOffice createBankOffice() {
        var bankOffice = new BankOffice();
        bankOffice.setAddress("address");
        bankOffice.setName("name");
        bankOffice.setRentPrice(BigDecimal.valueOf(1000));
        return bankOfficeRepository.save(bankOffice);
    }

    public void save(BankOffice bankOffice) {
        bankOfficeRepository.save(bankOffice);
    }

    public BankOffice addBankAtm(BankOffice bankOffice, BankAtm bankAtm) {
        if (!bankOffice.isAtmPossible()) {
            throw new RuntimeException("нельзя разместить банкомат в офисе");
        }

        bankOffice.setAtmsCount(bankOffice.getAtmsCount() + 1);
        return bankOfficeRepository.save(bankOffice);
    }

    public BankOffice addBank(BankOffice bankOffice, Bank bank) {
        bankOffice.setAmount(bank.getAmount().divide(BigDecimal.valueOf(10)));
        bankOffice.setBank(bank);
        return bankOfficeRepository.save(bankOffice);
    }
}
