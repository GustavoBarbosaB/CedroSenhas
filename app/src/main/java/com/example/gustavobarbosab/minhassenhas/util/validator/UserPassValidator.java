package com.example.gustavobarbosab.minhassenhas.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gustavobarbosab on 19/03/18.
 */

public class UserPassValidator {

    private Pattern pattern;
    private static UserPassValidator userPassValidator;

    private static final String PATTERN_PASS =
            "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[{}()^?&*!_=+@#$%]).{8,20})";

    private UserPassValidator() {
        pattern  = Pattern.compile(PATTERN_PASS);
    }

    public static UserPassValidator getInstance(){
        return userPassValidator!=null?userPassValidator:(new UserPassValidator());
    }

    public EnumUserPassValidator validateUserPass(String email, String password){
        if(validateUser(email).equals(EnumUserPassValidator.OK)){
            return validatePass(password);
        }else
            return EnumUserPassValidator.USERNAME;
    }

    public EnumUserPassValidator validateUser(String email){

        if(email!=null && !email.isEmpty() && email.contains("@") && email.contains(".com")){
            return EnumUserPassValidator.OK;
        }else
            return EnumUserPassValidator.USERNAME;
    }

    public EnumUserPassValidator validatePass(String password){
        Matcher matcher = pattern.matcher(password);
        return matcher.matches()? EnumUserPassValidator.OK: EnumUserPassValidator.PASSWORD;
    }
}
