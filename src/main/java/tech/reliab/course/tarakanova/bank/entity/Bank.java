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

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @GeneratedValue
    @Id
    UUID id;
    String name;
    Integer bankOfficesCount = 0;
    Integer atmsCount = 0;
    Integer employeesCount = 0;
    Integer clientsCount = 0;
    Double rating;
    BigDecimal amount;
    Double interestRate;
}
