package agisa;

import agisa.SRP.UserController;

import java.io.IOException;

public class Main {
    private static final String VALID_USER_JSON = "{\"name\": \"Ike\", \"email\": \"sample@email.com\", \"address\":\"110 Sample lane\"}";

    private static final String INVALID_USER_JSON = "{\"name\": \"Amy\", \"email\": \"sample@email\", \"address\":\"11 Sample lane\"}";
   public static void main(String[] args) throws IOException {

        UserController controller = new UserController();

        String response = controller.createUser(VALID_USER_JSON);
        if(!response.equalsIgnoreCase("Success")){
            System.out.println("Failed");
        }
        System.out.println("Valid JSON response received :" +response);

        response = controller.createUser(INVALID_USER_JSON);
        if(response.equalsIgnoreCase("ERrOR")){
            System.out.println("Failed");
        }

        System.out.println("InValid JSON response received :" +response);





    }
}