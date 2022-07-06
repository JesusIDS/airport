package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Model.Country;

import java.util.List;

public interface CountryService {
    Country findById(long id);
    List<Country> findAll();
    Country updateCountry(Country country);
    void deleteCountry(long id);
}
