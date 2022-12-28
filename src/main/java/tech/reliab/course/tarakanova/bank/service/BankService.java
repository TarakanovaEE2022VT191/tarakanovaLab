package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.Bank;
import tech.reliab.course.tarakanova.bank.repository.BankRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankService {
    private static final Integer MAX_AMOUNT = 1000000;
    private final BankRepository bankRepository;

    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    public Bank get(UUID id) {
        return bankRepository.findById(id).orElse(null);
    }

    public Bank createBank(String name) {
        var bank = new Bank();
        var rating = generateRating();
        bank.setName(name);
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
}
