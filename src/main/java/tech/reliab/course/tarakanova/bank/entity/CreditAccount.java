package tech.reliab.course.tarakanova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccount {
    @GeneratedValue
    @Id
    UUID id;
    @ManyToOne
    Client client;
    @OneToOne
    Bank bank;
    LocalDate startDate;
    LocalDate endDate;
    Integer numberMonths;
    BigDecimal amount;
    BigDecimal monthlyPayment;
    Double interestRate;
    @OneToOne
    Employee employer;
    @OneToOne
    PaymentAccount paymentAccount;
}
