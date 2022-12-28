package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.BankAtm;
import tech.reliab.course.tarakanova.bank.repository.BankAtmRepository;

@Service
@RequiredArgsConstructor
public class AtmService {
    private final BankAtmRepository bankAtmRepository;

    public BankAtm createAtm() {
        var atm = new BankAtm();
        atm.setName("atm");
        return bankAtmRepository.save(atm);
    }
}
