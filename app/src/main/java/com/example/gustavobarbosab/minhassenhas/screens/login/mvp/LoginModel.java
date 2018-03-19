package com.example.gustavobarbosab.minhassenhas.screens.login.mvp;

import com.example.gustavobarbosab.minhassenhas.domain.TokenResponse;
import com.example.gustavobarbosab.minhassenhas.domain.User;
import com.example.gustavobarbosab.minhassenhas.rest.service.LoginService;
import com.example.gustavobarbosab.minhassenhas.util.validator.EnumUserPassValidator;
import com.example.gustavobarbosab.minhassenhas.util.validator.UserPassValidator;

/**
 * Created by gustavobarbosab on 16/03/18.
 */

public class LoginModel {

    private TokenResponse token;
    private LoginService loginService;
    private User user;

    public LoginModel(LoginService loginService) {
        this.loginService=loginService;
        user = new User();
    }

    public EnumUserPassValidator startLogin(String username, String password) {

        EnumUserPassValidator valida = UserPassValidator
                                        .getInstance().validate(username,password);

        if(valida.equals(EnumUserPassValidator.OK)) {
            user.setEmail(username);
            user.setPassword(password);
            loginService.loginUser(user);
        }

        return valida;
    }


    public boolean setToken(TokenResponse token) {
        this.token=token;
        return token.getAccessToken() != null;
    }

}
