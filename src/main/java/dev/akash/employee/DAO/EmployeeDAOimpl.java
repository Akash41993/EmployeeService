package dev.akash.employee.DAO;

import dev.akash.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findall() {
        TypedQuery<Employee>query=entityManager.createQuery("From Employee", Employee.class);//writes the query for the database(select * from employees
        List<Employee>employees=query.getResultList();// gives result in the list<employees>
        return employees;
    }

    @Override
    public Employee findbyid(int id) {
        Employee e=entityManager.find(Employee.class,id);
        return e;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee e=entityManager.merge(theEmployee);
        return e;
    }

    @Override
    public void deletebyId(int id) {
        Employee e=entityManager.find(Employee.class,id);
        entityManager.remove(e);
    }


}
