package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Model.Airport;

import java.util.List;

public interface AirportService {
    Airport findById(long id);
    List<Airport> findAll();
    Airport updateAirport(Airport airport);
    void deleteAirport(long id);
}
