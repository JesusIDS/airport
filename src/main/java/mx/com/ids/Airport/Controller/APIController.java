package mx.com.ids.Airport.Controller;

import mx.com.ids.Airport.Model.Airport;
import mx.com.ids.Airport.Model.Country;
import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Model.Language;
import mx.com.ids.Airport.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apiv1/clientes")
public class APIController {
    @GetMapping
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok().body("API V1");
    }

    @Autowired
    private AirportService airportService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body("Database Upgrade");
    }

    /*@Autowired
    private APIService apiService;

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody String data) {
        System.out.println(data);
        data = data.replace("{", "").replace("}", "")
                .replace(" ", "").replace("\"", "")
                .replaceAll("\\R", "");
        String[] lista = data.split(",");
        for (int i = 0; i < 5; i++) {
            System.out.println(lista[i]);
        }
        Employee employee = new Employee(lista[1].split(":")[1], lista[0].split(":")[1]);
        this.apiService.createEmployee(employee);
        Country country = new Country(lista[2].split(":")[1]);
        this.apiService.createCountry(country);
        Language language = new Language(lista[3].split(":")[1]);
        this.apiService.createLanguage(language);
        Airport airport = new Airport(lista[4].split(":")[1]);
        this.apiService.createAirport(airport);
        return ResponseEntity.ok().body("Database Upgrade");
    }*/
}
