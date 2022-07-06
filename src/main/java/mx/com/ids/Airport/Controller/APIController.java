package mx.com.ids.Airport.Controller;

import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiv1/clientes")
public class APIController {
    @GetMapping
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok().body("API V1");
    }

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        this.employeeService.createEmployee(employee);
        return ResponseEntity.ok().body("Database Upgrade");
    }
}
