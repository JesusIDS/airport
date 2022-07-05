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
    private long id;
    private String code;
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airport> airports;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Country(String name) {
        this.name = name;
    }
}
