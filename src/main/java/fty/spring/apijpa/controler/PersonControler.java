package fty.spring.apijpa.controler;

import fty.spring.apijpa.model.Person;
import fty.spring.apijpa.repositiory.PersonRepository;
import java.util.Optional;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utilisateur
 */
@RestController
@RequestMapping("/api/persons")
public class PersonControler {

    private final PersonRepository personRepository;

    public PersonControler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Get random person
    @GetMapping("/random")
    public ResponseEntity<Person> getRandom() {
        Random random = new Random();
        long randomId = random.nextInt((int) personRepository.count() - 1) + 1;

        Optional<Person> person = personRepository.findById(randomId);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        }

        return ResponseEntity.notFound().build();
    }
}
