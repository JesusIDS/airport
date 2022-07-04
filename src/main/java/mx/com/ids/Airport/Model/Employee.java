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

    @OneToOne(mappedBy = "employee")
    private Country country;

    @ManyToMany
    Set<Language> languages;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }
}
