package mx.com.ids.Airport.Repository;

import mx.com.ids.Airport.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRep extends JpaRepository<Country, Long> {
}
