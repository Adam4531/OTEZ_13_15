package pl.otez.interfaces;

import java.util.Locale;

public interface Validator {

    default boolean containsValidCharacters(String stringToCheck, String pattern){
        return stringToCheck.matches(pattern);
    }

    default boolean isValidLength(String stringToCheck, int minimumLength, int maximumLength){
        return stringToCheck.length() >= minimumLength && stringToCheck.length() <= maximumLength;
    }
}
