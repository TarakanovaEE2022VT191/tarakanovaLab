package tech.reliab.course.tarakanova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class BankOffice {
    @GeneratedValue
    @Id
    UUID id;
    String name;
    String address;
    @Enumerated(EnumType.STRING)
    StatusBankOffice status;
    boolean isAtmPossible;
    Integer atmsCount = 0;
    boolean isCreditPossible;
    boolean cashIn;
    boolean cashOut;
    BigDecimal amount;
    BigDecimal rentPrice;
    @ManyToOne
    Bank bank;
}
