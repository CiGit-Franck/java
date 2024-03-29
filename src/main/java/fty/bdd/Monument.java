package fty.bdd;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author utilisateur
 */
@Entity
@Table(name = "Monument")
public class Monument implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 255)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city")
    private City city;
    @ManyToMany(mappedBy = "monuments")
    private Set<User> users = new HashSet<User>();

    public Monument(String name) {
        super();
        this.name = name;
    }

    public Monument() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Monument [id=" + id + ", name=" + name
                + ", city=" /*+ city */ + "]";
    }
}
