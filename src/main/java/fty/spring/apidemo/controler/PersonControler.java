package fty.spring.apidemo.controler;

import fty.spring.apidemo.model.Person;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utilisateur
 */
@RestController
@RequestMapping("/api/persons")
public class PersonControler {

    private List<Person> personList = List.of(
            new Person("thery", "franck", "1690159", LocalDate.of(1969, 1, 16))
    );

    @GetMapping()
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personList);
    }

    @PostMapping()
    public void create(@RequestBody Person newPerson) {
        personList.add(newPerson);
    }
    
    @GetMapping("{paramSearch}")
    public ResponseEntity<Person > getOne(@PathVariable String paramSearch){
        for(Person person:personList){
            if(person.getNumSS().equalsIgnoreCase(paramSearch)){
                return ResponseEntity.ok(person);            }
        }
        return ResponseEntity.notFound().build();
    }
}
