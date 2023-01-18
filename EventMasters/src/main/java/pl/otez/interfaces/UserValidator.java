package pl.otez.interfaces;

public interface UserValidator {

    String POLISH_ALPHABET = "[a-zA-Z-\\p{IsAlphabetic}]+";

    default Boolean emailContainsAtSign(String email){
        return email != null && email.contains("@");
    }

    default Boolean passwordIsValidLength(String password){
        return password != null && password.length() > 8;
    }

    default Boolean loginIsValidLength(String login){
        return login != null && login.length() > 5;
    }

    default Boolean nameContainsValidSigns(String firstName, String secondName){
        return firstName != null && firstName.matches(POLISH_ALPHABET)
                && secondName != null && secondName.matches(POLISH_ALPHABET);
    }
}
