package mx.com.ids.Airport.Repository;

import mx.com.ids.Airport.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRep extends JpaRepository<Airport, Long> {
}
