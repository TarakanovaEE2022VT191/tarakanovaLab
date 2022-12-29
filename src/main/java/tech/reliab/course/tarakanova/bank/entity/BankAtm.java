package tech.reliab.course.tarakanova.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id"})
public class BankAtm {
    @GeneratedValue
    @Id
    UUID id;
    String name;
    String address;
    @Enumerated(EnumType.STRING)
    StatusAtm status = StatusAtm.NOT_WORKS;
    @ManyToOne
    Bank bank;
    @OneToOne
    Employee employer;
    boolean cashIn;
    boolean cashOut;
    BigDecimal amount;
    BigDecimal maintenanceCost;
}
