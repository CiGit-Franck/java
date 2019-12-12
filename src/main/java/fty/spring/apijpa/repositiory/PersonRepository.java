package fty.spring.apijpa.repositiory;

import fty.spring.apijpa.model.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author utilisateur
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByLastName(String lastName);
}
