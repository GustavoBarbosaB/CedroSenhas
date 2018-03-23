package com.example.gustavobarbosab.minhassenhas;

import com.example.gustavobarbosab.minhassenhas.util.validator.EnumUserPassValidator;
import com.example.gustavobarbosab.minhassenhas.util.validator.UserPassValidator;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by gustavobarbosab on 23/03/18.
 */

public class PasswordValidatorTest {

    @Test
    public void ValidPasswordTest() {
        EnumUserPassValidator enumUserPassValidator = UserPassValidator.getInstance().validatePass("Senha@12346");
        Assert.assertEquals(EnumUserPassValidator.OK,enumUserPassValidator);

    }

    @Test
    public void InValidPasswordTest() {
        EnumUserPassValidator enumUserPassValidator = UserPassValidator.getInstance().validatePass("Senha12346");
        Assert.assertEquals(EnumUserPassValidator.PASSWORD,enumUserPassValidator);
    }
}