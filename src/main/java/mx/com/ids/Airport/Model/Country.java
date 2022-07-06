package mx.com.ids.Airport.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Modelo de entidad 'country'
 * +id
 * +code
 * +name
 */
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long country_id;
    private String code;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "country_id")
    private List<Airport> airportsCountry;

    @OneToOne(mappedBy = "countryWork", cascade = CascadeType.ALL)
    private Employee employee;

    public Country() {
    }

    public long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(long country_id) {
        this.country_id = country_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airport> getAirportsCountry() {
        return airportsCountry;
    }

    public void setAirportsCountry(List<Airport> airportsCountry) {
        this.airportsCountry = airportsCountry;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
