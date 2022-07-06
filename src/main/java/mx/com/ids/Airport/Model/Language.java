package mx.com.ids.Airport.Model;

import javax.persistence.*;
import java.util.List;

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
    private long language_id;
    private String code;
    private String name;

    @ManyToMany(mappedBy = "languageSpeaks", cascade = CascadeType.PERSIST)
    private List<Employee> speaks;

    public Language() {
    }

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
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

    public List<Employee> getSpeaks() {
        return speaks;
    }

    public void setSpeaks(List<Employee> speaks) {
        this.speaks = speaks;
    }
}
