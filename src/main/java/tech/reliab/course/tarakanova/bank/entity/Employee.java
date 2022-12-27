package tech.reliab.course.tarakanova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Employee {
    @GeneratedValue
    @Id
    UUID id;
    String firstName;
    String LastName;
    String MiddleName;
    LocalDate birthDate;
    String position;
    @OneToOne
    Bank bank;
    boolean isRemote;
    @OneToOne
    BankOffice bankOffice;
    boolean isIssueCredit;
    BigDecimal pay;
}
