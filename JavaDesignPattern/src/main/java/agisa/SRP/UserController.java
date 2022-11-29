package agisa.SRP;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UserController {
    /*
    Srp stands for single responsibility principle
    it is role to make sure class handles only single job
    not many not 2 only one
     */
    UserPersistanceService userPersistanceService = new UserPersistanceService();
    public String createUser(String userjson) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userjson,User.class);

        UserValidator validator = new UserValidator();
        boolean valid = validator.validateUser(user);

        if(!valid){
            return "ERROR";
        }
        userPersistanceService.saveUser(user);
        return("SUCCESS");
    }




}
