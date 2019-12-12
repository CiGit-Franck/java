package fty.spring.apidemo.controler;

import fty.spring.apidemo.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author utilisateur
 */
@RestController
@RequestMapping("/api")
public class HelloWordControler {

    @GetMapping("/helloword")
    public String helloWorld() {
        return "Hello World !";
    }

    @GetMapping("/message")
    public ResponseEntity<Message> printMessage() {
        return ResponseEntity.ok(new Message("Ca marche pô !"));
    }

    @PostMapping("/message")
    public ResponseEntity<Message> addMessage(@RequestBody Message msg) {
        return ResponseEntity.ok(msg);
    }
}
