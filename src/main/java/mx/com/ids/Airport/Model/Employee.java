package mx.com.ids.Airport.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Modelo de entidad 'employee'
 *+id
 * +surname
 * +firstname
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String surname;
    private String firstname;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Language> languages;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Employee(String surname, String firstname) {
        this.surname = surname;
        this.firstname = firstname;
    }
}
