package com.k21cnt.ntt.labguide04.Service;

import com.k21cnt.ntt.labguide04.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private Long nextId = 1L;

    public EmployeeService() {
        // Initialize with 5 Employee objects
        employeeList.add(new Employee("Nguyen Van A", "Male", 25, 5000));
        employeeList.add(new Employee("Tran Thi B", "Female", 30, 6000));
        employeeList.add(new Employee("Le Van C", "Male", 28, 5500));
        employeeList.add(new Employee("Pham Thi D", "Female", 35, 7000));
        employeeList.add(new Employee("Hoang Van E", "Male", 40, 8000));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeList);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(nextId++);
        employeeList.add(employee);
        return employee;
    }

    public boolean updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = getEmployeeById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setFullName(updatedEmployee.getFullName());
            employee.setGender(updatedEmployee.getGender());
            employee.setAge(updatedEmployee.getAge());
            employee.setSalary(updatedEmployee.getSalary());
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}