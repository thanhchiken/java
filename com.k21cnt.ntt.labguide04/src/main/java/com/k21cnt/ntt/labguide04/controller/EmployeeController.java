package com.k21cnt.ntt.labguide04.controller;

import com.k21cnt.ntt.labguide04.dto.EmployeeDTO;
import com.k21cnt.ntt.labguide04.entity.Employee;
import com.k21cnt.ntt.labguide04.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getFullName(), employeeDTO.getGender(), employeeDTO.getAge(), employeeDTO.getSalary());
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = new Employee(employeeDTO.getFullName(), employeeDTO.getGender(), employeeDTO.getAge(), employeeDTO.getSalary());
        boolean updated = employeeService.updateEmployee(id, updatedEmployee);
        if (updated) {
            return ResponseEntity.ok("Cập nhật nhân viên thành công");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.ok("Xóa nhân viên thành công");
        }
        return ResponseEntity.notFound().build();
    }
}