package tech.reliab.course.tarakanova.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.tarakanova.bank.entity.Bank;
import tech.reliab.course.tarakanova.bank.entity.BankOffice;
import tech.reliab.course.tarakanova.bank.entity.Employee;
import tech.reliab.course.tarakanova.bank.repository.EmployeeRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmployerService {
    private final EmployeeRepository employeeRepository;

    public Employee createEmployer(String name) {
        var employer = new Employee();
        employer.setFirstName(name);
        employer.setPosition("position");
        employer.setBirthDate(LocalDate.now().minusYears(50));
        return employeeRepository.save(employer);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee addBank(Employee employee, Bank bank, BankOffice bankOffice) {
        employee.setBank(bank);
        employee.setBankOffice(bankOffice);
        return employeeRepository.save(employee);
    }
}
