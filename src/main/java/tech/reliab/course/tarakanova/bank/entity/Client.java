package tech.reliab.course.tarakanova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id"})
public class Client {
    @GeneratedValue
    @Id
    UUID id;
    String firstName;
    String LastName;
    String MiddleName;
    String placeWork;
    BigDecimal monthlyIncome;
    @ManyToMany
    Set<Bank> banks = new HashSet<>();
    @OneToMany(mappedBy = "client")
    Set<CreditAccount> creditAccounts = new HashSet<>();
    @OneToMany(mappedBy = "client")
    Set<PaymentAccount> paymentAccounts = new HashSet<>();
    Integer creditRating;
}
