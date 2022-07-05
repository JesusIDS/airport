package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Model.Airport;
import mx.com.ids.Airport.Model.Country;
import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Model.Language;
import mx.com.ids.Airport.Repository.AirportRep;
import mx.com.ids.Airport.Repository.CountryRep;
import mx.com.ids.Airport.Repository.EmployeeRep;
import mx.com.ids.Airport.Repository.LanguageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class APIImplement implements APIService{
    @Autowired
    private AirportRep airportRep;
    @Autowired
    private CountryRep countryRep;
    @Autowired
    private EmployeeRep employeeRep;
    @Autowired
    private LanguageRep languageRep;

    @Override
    public Airport createAirport(Airport airport) {
        return this.airportRep.save(airport);
    }

    @Override
    public Country createCountry(Country country) {
        return this.countryRep.save(country);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRep.save(employee);
    }

    @Override
    public Language createLanguage(Language language) {
        return this.languageRep.save(language);
    }
}
