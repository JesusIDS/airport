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

    @OneToMany(mappedBy = "country")
    private List<Airport> airports;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee", insertable = false,
            updatable = false, referencedColumnName = "id")
    private Employee employee;

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

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
