package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Exception.ResourceNotFoundException;
import mx.com.ids.Airport.Model.Country;
import mx.com.ids.Airport.Repository.CountryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryImplement implements CountryService{
    @Autowired
    private CountryRep  countryRep;


    @Override
    public Country findById(long id) {
        Optional<Country> countryDb = this.countryRep.findById(id);
        if (countryDb.isPresent()) {
            return countryDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public List<Country> findAll() {
        return this.countryRep.findAll();
    }

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> countryDb = this.countryRep.findById(country.getCountry_id());
        if (countryDb.isPresent()) {
            Country countryUpdate = countryDb.get();
            countryUpdate.setCountry_id(country.getCountry_id());
            countryUpdate.setCode(country.getCode());
            countryUpdate.setName(country.getName());
            return countryUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + country.getCountry_id());
        }
    }

    @Override
    public void deleteCountry(long id) {
        Optional<Country> countryDb = this.countryRep.findById(id);
        if (countryDb.isPresent()) {
            this.countryRep.delete(countryDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

}
