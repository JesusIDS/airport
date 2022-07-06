package mx.com.ids.Airport.Controller;

import mx.com.ids.Airport.Exception.Mensaje;
import mx.com.ids.Airport.Model.Country;
import mx.com.ids.Airport.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @GetMapping
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok().body("COUNTRY CONTROLLER");
    }

    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Country> lista = countryService.findAll();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin paises en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(countryService.findById(id));
    }

    @PutMapping("/update_country/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country) {
        country.setCountry_id(id);
        return ResponseEntity.ok().body(this.countryService.updateCountry(country));
    }

    @DeleteMapping("/delete_country/{id}")
    public HttpStatus deleteCountry(@PathVariable long id) {
        this.countryService.deleteCountry(id);
        return HttpStatus.OK;
    }
}
