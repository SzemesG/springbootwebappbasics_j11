package de.rockethome.springbootwebappbasics_j11;

import org.springframework.web.bind.annotation.*;

@RestController
public class ToyControllerJ11 {

    // we can also return complex objects back to the user (from the Toy class)
    // Spring by default is able to convert this POJO (Toy) into JSON !!! (key:value -pairs)
    // http://localhost:8080/toy/elephant --> JSON representation of this POJO

    @GetMapping("/toy/elephant")
    public Toy elephant() {
        return new Toy("eli", "medium", "gray");
    }

    // similarly we can also accept a JSON without having to map that JSON into a POJO, which is a Java Object
    // earlier we had @GetMapping, than we can use @PostMapping
    // whatever data is there in the @RequestBody --> convert it into this POJO (Toy)
    // so we are passing (converting) a particular JSON representation (not now, just showes the method as the way to it)
    // into a Java Object, what the instance of Toy is and assigned to the variable 'newToy' automatically by Spring

    @PostMapping("/toy/add")
    public void addToy(@RequestBody Toy newToy){
        addToDatabase(newToy);
    }



    private void addToDatabase(Toy newToy) {

    }

}
