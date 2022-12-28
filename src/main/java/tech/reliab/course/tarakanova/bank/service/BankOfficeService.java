package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.BankOffice;
import tech.reliab.course.tarakanova.bank.repository.BankOfficeRepository;

@Service
@RequiredArgsConstructor
public class BankOfficeService {
    private final BankOfficeRepository bankOfficeRepository;

    public BankOffice createBankOffice(String name) {
        var bankOffice = new BankOffice();
        bankOffice.setAddress("address");
        bankOffice.setName(name);
        return bankOfficeRepository.save(bankOffice);
    }
}
