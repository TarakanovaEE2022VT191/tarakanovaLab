package tech.reliab.course.tarakanova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "name", "employes", "clients", "atms", "bankOffices", "amount"})
public class Bank {
    @GeneratedValue
    @Id
    UUID id;
    String name;
    Integer bankOfficesCount = 0;
    Integer atmsCount = 0;
    Integer employeesCount = 0;
    Integer clientsCount = 0;
    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER)
    Set<BankOffice> bankOffices = new HashSet<>();
    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER)
    Set<BankAtm> atms = new HashSet<>();
    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER)
    Set<Employee> employes = new HashSet<>();
    @ManyToMany(mappedBy = "banks", fetch = FetchType.EAGER)
    Set<Client> clients = new HashSet<>();
    Double rating;
    BigDecimal amount;
    Double interestRate;
}
