package dev.akash.employee.Rest;

import dev.akash.employee.entity.Employee;
import dev.akash.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findall() {
        return employeeService.findall();
    }


    @GetMapping("/employees/{employeeId}")
        public Employee findbyid(@PathVariable int employeeId){
            Employee theemployee= employeeService.findbyid(employeeId);
            if(theemployee==null){
                throw new RuntimeException("Employee id not found "+employeeId);
            }
            return theemployee;
    }
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        Employee em=employeeService.save(theEmployee);
        return em;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deletebyId(@PathVariable int employeeId){
        Employee em=employeeService.findbyid(employeeId);
        if(em==null){
            throw new RuntimeException("Employee not found with id "+employeeId);
        }
        employeeService.deletebyId(employeeId);
        return ("Employee with id "+employeeId+" deleted");

    }
    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee){
        Employee em=employeeService.save(theEmployee);
        return em;
    }
}

