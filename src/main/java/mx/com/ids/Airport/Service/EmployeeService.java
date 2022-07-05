package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(long id);
    List<Employee> findAll();
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long id);
    Employee createEmployee(Employee employee);
}
