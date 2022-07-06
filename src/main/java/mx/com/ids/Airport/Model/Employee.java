package mx.com.ids.Airport.Model;

import javax.persistence.*;
import java.util.List;

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
    private long employee_id;
    private String surname;
    private String firstname;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "languages_speaks",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languageSpeaks;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country countryWork;

    public Employee() {
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
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

    public List<Language> getLanguageSpeaks() {
        return languageSpeaks;
    }

    public void setLanguageSpeaks(List<Language> languageSpeaks) {
        this.languageSpeaks = languageSpeaks;
    }

    public Country getCountryWork() {
        return countryWork;
    }

    public void setCountryWork(Country countryWork) {
        this.countryWork = countryWork;
    }
}
