package mx.com.ids.Airport.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * Modelo de entidad 'language'
 * +id
 * +code
 * +name
 */
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;
    private String name;

    @ManyToMany
    Set<Employee> speaks;

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

    public Set<Employee> getSpeaks() {
        return speaks;
    }

    public void setSpeaks(Set<Employee> speaks) {
        this.speaks = speaks;
    }
}
