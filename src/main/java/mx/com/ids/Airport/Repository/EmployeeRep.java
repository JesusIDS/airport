package mx.com.ids.Airport.Repository;

import mx.com.ids.Airport.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRep extends JpaRepository<Employee, Long> {
}
