package com.example.yovo_user.restproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private static Pattern pattern;
    private static Matcher matcher;
    //Email Pattern
    private static final String INT_NUMBER_PATTERN =
            "^(?<=\\s|^)[-+]?\\d+(?=\\s|$)$";


    /**
     * Проверяване на Email чрез Регулярен израз
     * @param numberToConvert
     * @return връща true за валиден Email и false за невалиден
    Email
     */
    public static boolean validate(String numberToConvert) {
        pattern = Pattern.compile(INT_NUMBER_PATTERN);
        matcher = pattern.matcher(numberToConvert);
        return matcher.matches();
    }

    /**
     * проверява за Null String object
     *
     * @param txt
     * @return true връща когато не е нула и false за null String
    object
     */
    public static boolean isNotNull(String txt){
        return txt != null && txt.trim().length() > 0 ? true: false;
    }
}