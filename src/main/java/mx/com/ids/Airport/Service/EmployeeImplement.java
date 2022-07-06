package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Exception.ResourceNotFoundException;
import mx.com.ids.Airport.Model.Country;
import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Repository.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeImplement implements EmployeeService{
    @Autowired
    private EmployeeRep employeeRep;

    @Override
    public Employee findById(long id) {
        Optional<Employee> employeeDb = this.employeeRep.findById(id);
        if (employeeDb.isPresent()) {
            return employeeDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRep.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = this.employeeRep.findById(employee.getEmployee_id());
        if (employeeDb.isPresent()) {
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setEmployee_id(employee.getEmployee_id());
            employeeUpdate.setSurname(employee.getSurname());
            employeeUpdate.setFirstname(employee.getFirstname());
            return employeeUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employee.getEmployee_id());
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employeeDb = this.employeeRep.findById(id);
        if (employeeDb.isPresent()) {
            this.employeeRep.delete(employeeDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRep.save(employee);
    }
}
