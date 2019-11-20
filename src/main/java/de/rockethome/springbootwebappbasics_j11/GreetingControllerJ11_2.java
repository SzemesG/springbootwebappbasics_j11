package de.rockethome.springbootwebappbasics_j11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GreetingControllerJ11_2 {

    // we have a use case, where we allowing a secret greeting to be returned, only for users, who know the secret
    // if it's not "abc123" --> we send the status as "UNAUTHORIZED" with error message (HTTP Status 401)
    // localhost:8080/secret-greeting?name=Dora&secret=abc123

    @GetMapping("/secret-greeting")
    public ResponseEntity<String>greet(@RequestParam String name,
                                       @RequestParam String secret){

        if (!"abc123".equals(secret)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");
        }

        return ResponseEntity.ok("Welcome to the toy land, " + name);
    }
}
