package com.example.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> getAllEmployees()
  {
        return employeeRepository.findAll();
  }

  public Optional<Employee> getEmployeeById(Long id)
  {
    return employeeRepository.findById(id);
  }

  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Employee updateEmployee(Long id, Employee employeeDetails)
  {
    Employee employee = employeeRepository.findById(id).orElseThrow();
    employee.setName(employeeDetails.getName());
    employee.setRole(employeeDetails.getRole());
    employee.setDepartment(employeeDetails.getDepartment());
    return employeeRepository.save(employee);
  }

  public void deleteEmployee(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow();
    employeeRepository.delete(employee);
  }
}
