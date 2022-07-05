package mx.com.ids.Airport.Controller;

import mx.com.ids.Airport.Exception.Mensaje;
import mx.com.ids.Airport.Model.Airport;
import mx.com.ids.Airport.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @GetMapping
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok().body("AIRPORT CONTROLLER");
    }

    @Autowired
    private AirportService airportService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Airport> lista = airportService.findAll();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin aeropuertos en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(airportService.findById(id));
    }

    @PutMapping("/update_airport/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport) {
        airport.setId(id);
        return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
    }

    @DeleteMapping("/delete_airport/{id}")
    public HttpStatus deleteAirport(@PathVariable long id) {
        this.airportService.deleteAirport(id);
        return HttpStatus.OK;
    }

}
