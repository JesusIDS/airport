package mx.com.ids.Airport.Model;

import javax.persistence.*;

/**
 * Modelo de entidad 'airport'
 * +id
 * +name
 */
@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airport_id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;

    public Airport() {
    }

    public long getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(long airport_id) {
        this.airport_id = airport_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
