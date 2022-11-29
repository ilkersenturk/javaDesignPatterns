package agisa.SRP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public boolean validateUser(User user){



        return isValidUser(user);
    }

    private boolean isValidUser(User user) {

        if (!isPresent(user.getName())) {
            return false;
        }
        user.setName(user.getName().trim());

        if (!isAlphaNumeric(user.getName())) {
            return false;
        }
        if (user.getEmail() == null || user.getEmail().trim().length() == 0) {
            return false;
        }
        user.setEmail(user.getEmail().trim());

        if (!isValidEmail(user.getEmail())) {
            return false;
        }
        return true;
    }


    private boolean isPresent(String username){
        return username != null && username.trim().length()>0;
    }

    private boolean isAlphaNumeric(String username){

        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(username);

        return !matcher.find();

    }

    private boolean isValidEmail(String email){

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();

    }

}
