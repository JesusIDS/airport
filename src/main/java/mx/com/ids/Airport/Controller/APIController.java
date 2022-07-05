package mx.com.ids.Airport.Controller;

import mx.com.ids.Airport.Model.Airport;
import mx.com.ids.Airport.Model.Country;
import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Model.Language;
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
    private APIService apiService;

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee, @RequestBody Country country,
                                            @RequestBody Language language, @RequestBody Airport airport) {
        this.apiService.createEmployee(employee);
        this.apiService.createAirport(airport);
        this.apiService.createCountry(country);
        this.apiService.createLanguage(language);
        return ResponseEntity.ok().body("Database Upgrade");
    }
}
