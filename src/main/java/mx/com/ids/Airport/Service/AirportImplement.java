package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Exception.ResourceNotFoundException;
import mx.com.ids.Airport.Model.Airport;
import mx.com.ids.Airport.Repository.AirportRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportImplement implements AirportService {

    @Autowired
    private AirportRep airportRep;

    @Override
    public Airport findById(long id) {
        Optional<Airport> airportDb = this.airportRep.findById(id);
        if (airportDb.isPresent()) {
            return airportDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public List<Airport> findAll() {
        return this.airportRep.findAll();
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRep.findById(airport.getId());
        if (airportDb.isPresent()) {
            Airport airportUpdate = airportDb.get();
            airportUpdate.setId(airport.getId());
            airportUpdate.setName(airport.getName());
            return airportUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getId());
        }
    }

    @Override
    public void deleteAirport(long id) {
        Optional<Airport> airportDb = this.airportRep.findById(id);
        if (airportDb.isPresent()) {
            this.airportRep.delete(airportDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public Airport createAirport(Airport airport) {
        return this.airportRep.save(airport);
    }
}
