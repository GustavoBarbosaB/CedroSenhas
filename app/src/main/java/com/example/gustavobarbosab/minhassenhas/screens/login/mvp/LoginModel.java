package com.example.gustavobarbosab.minhassenhas.screens.login.mvp;

import com.example.gustavobarbosab.minhassenhas.domain.Token;
import com.example.gustavobarbosab.minhassenhas.domain.User;
import com.example.gustavobarbosab.minhassenhas.service.LoginService;

/**
 * Created by gustavobarbosab on 16/03/18.
 */

public class LoginModel {

    private Token token;
    private LoginService loginService;
    private User user;

    public LoginModel(LoginService loginService) {
        this.loginService=loginService;
        user = new User();
    }

    public boolean startLogin(String username, String password) {

        if(validaUsername(username) && validaPassword(password)) {
            user.setEmail(username);
            user.setPassword(password);
            loginService.loginUser(user);
            return true;
        }

        return false;
    }

    private boolean validaPassword(String password) {
        return !password.isEmpty();
    }

    private boolean validaUsername(String username) {
        /*TODO implementar validação username e password*/
        return !(username.isEmpty() || !username.contains("@"));
    }

    public boolean setToken(Token token) {
        this.token=token;
        return token.getAccessToken() != null;
    }

}
