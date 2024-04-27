package dev.akash.employee.services;

import dev.akash.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findall();

    public Employee findbyid(int id);

    public Employee save(Employee theEmployee);

    public void deletebyId(int id);
}
