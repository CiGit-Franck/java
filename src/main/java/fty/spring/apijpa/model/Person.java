package fty.spring.apijpa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author utilisateur
 */
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="person_generator", sequenceName="person_id_seq", allocationSize=1)
    private Long id;
    
    @Column
    private String lastName;
    @Column
    private String firstName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
}
