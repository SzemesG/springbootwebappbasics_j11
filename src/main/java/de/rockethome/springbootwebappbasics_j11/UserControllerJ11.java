package de.rockethome.springbootwebappbasics_j11;

// we can extract or separate out the common prefix "/user" between all the URLs,
// --> and add it at the top ---> @RequestMapping("/user")


import org.springframework.web.bind.annotation.*;

@RestController
public class UserControllerJ11 {

    // it also allows us to extract path variables
    // within the paths wherever there is an {id} --> extract that and put it in this variable "id"
    // than value is parsed automatically into an int (int userId)
    // and than we can use this int variable to get the userName
    // http://localhost:8080/user/45/name --> Dora

    @GetMapping("/user/{id}/name")
    public String greet(@PathVariable(value = "id") int userId){
        return getUserName(userId);
    }

    //we can also extract a request-header
    // than as value can we give, which request-header we want to extract
    // ny default there is a request-header called "Accept-Language"
    // it can also be a custom header, like secret tokens, that you can pass in
    // http://localhost:8080/request-header --> de-de


    @GetMapping("/request-header")
    public String language(@RequestHeader(value = "Accept-Language") String language) {
        return language;
    }

    // of course we will not have just one URL to manage
    // we can manage them, either use a single controller,
    // or we can split them based on their functionality in multiple controllers
    // we add as example "age" - URL-Mapping in this single class

    @GetMapping("/user/{id}/age")
    public int age(@PathVariable(value = "id") int userId) {
        return getUserAge(userId);
    }

    private String getUserName(int userId) {
        return "Dora";
    }

    private int getUserAge(int userId) {
        if(userId==1){
            return 31;
        } else {
            return 41;
        }
    }


}
