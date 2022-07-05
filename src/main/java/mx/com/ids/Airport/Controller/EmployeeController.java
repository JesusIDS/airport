package mx.com.ids.Airport.Controller;

import mx.com.ids.Airport.Exception.Mensaje;
import mx.com.ids.Airport.Model.Airport;
import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok().body("EMPLOYEE CONTROLLER");
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Employee> lista = employeeService.findAll();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @PutMapping("/update_employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setId(id);
        return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/delete_employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }
}
