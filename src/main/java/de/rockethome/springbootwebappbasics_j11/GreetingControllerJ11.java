package de.rockethome.springbootwebappbasics_j11;

import org.assertj.core.util.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GreetingControllerJ11 {

    // localhost:8080/greeting?name=Gabor

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greet(@RequestParam(value = "name") String userName) {
        return "Hello there, " + userName + "!";
    }

    // if the name of our parameter is the same as the name of our variable
    //than we do not have to add anything in the brackets (value = ...) of request --> simplify
    // localhost:8080/greetings?sname=Daniel

    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String greetSimplify(@RequestParam String sname){
        return "Hello there, " + sname + "!!";
    }

    // we can also have multiple parameters
    // localhost:8080/greetingm?name=Gabor&time=morning

    @RequestMapping(value = "/greetingm", method = RequestMethod.GET)
    public String greetMultipleParam(@RequestParam String name,
                                     @RequestParam String time) {
        return "Good " + time + ", " + name + "!";
    }

    // we can also have optional parameters
    // example: one user not always set the time --> @RequestParam(required = false) String time
    // --> explicitly mention that this parameter not required all the time (required boolean default is true)
    // localhost:8080/greetingo?name=Andre

    @RequestMapping(value = "/greetingo", method = RequestMethod.GET)
    public String greetOptionalParam(@RequestParam String name,
                                     @RequestParam(required = false) String time) {

        if (time == null){
            time = "day";                           // then we are assigning some default value
        }
        return "Good " + time + ", " + name + "!";
    }

    // it also allows for us to directly set the default value in the request parameter -->
    // --> @RequestParam(required = false, defaultValue = "day") String time
    // localhost:8080/greetingd?name=Sönke

    @RequestMapping(value = "/greetingd", method = RequestMethod.GET)
    public String greetDefaultParam(@RequestParam String name,
                                    @RequestParam(required = false, defaultValue = "day") String time) {
        return "Good " + time + ", " + name + "!";
    }

    // in this case, instead of having a free text of time, we are allowing only two values for this variable,
    // we are allowing only 'evening' and 'morning' to be passed in 'time'.
    // We can explicitly send a Bad request (HTTP status 400) and some custom error message with it.
    // We can not have the return type a String, we have to have a special return typeof the ResponseEntity.
    // Responsentity.badrequest --> custom error message
    // ResponseEntity.ok --> successful response (HTTP status 200)

   List<String> times = Lists.newArrayList("evening", "morning");

    @GetMapping("/greetingbad")
    public ResponseEntity<String> greet(@RequestParam String name,
                                        @RequestParam String time) {

        if (!times.contains(time)) {
            return ResponseEntity.badRequest().body("Time should be morning/evening");
        }

        return ResponseEntity.ok("Good " + time + ", " + name);
    }

}
