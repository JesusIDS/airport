package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Model.Airport;
import mx.com.ids.Airport.Model.Country;
import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Model.Language;

public interface APIService {
    Airport createAirport(Airport airport);
    Country createCountry(Country country);
    Employee createEmployee(Employee employee);
    Language createLanguage(Language language);
}
