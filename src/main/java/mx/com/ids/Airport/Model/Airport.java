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
    private long id;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Airport(String name) {
        this.name = name;
    }
}
