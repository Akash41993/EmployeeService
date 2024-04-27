package dev.akash.employee.services;

import dev.akash.employee.DAO.EmployeeDAO;
import dev.akash.employee.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @Override
    public List<Employee> findall() {
        return employeeDAO.findall();
    }

    @Override
    public Employee findbyid(int id) {
        return employeeDAO.findbyid(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        Employee e=employeeDAO.save(theEmployee);
        return e;
    }

    @Override
    @Transactional
    public void deletebyId(int id) {
        employeeDAO.deletebyId(id);
    }
}
