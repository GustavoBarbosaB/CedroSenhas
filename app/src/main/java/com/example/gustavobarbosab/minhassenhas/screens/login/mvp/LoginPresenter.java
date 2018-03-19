package com.example.gustavobarbosab.minhassenhas.screens.login.mvp;

import android.content.Intent;
import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.TokenResponse;
import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.login.LoginActivity;
import com.example.gustavobarbosab.minhassenhas.util.validator.EnumUserPassValidator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by gustavobarbosab on 16/03/18.
 */

public class LoginPresenter implements BasePresenter {

    private LoginActivity loginActivity;
    private LoginModel loginModel;
    private EventBus eventBus;

    public LoginPresenter(LoginActivity loginActivity, LoginModel loginModel, EventBus eventBus) {
        this.loginActivity = loginActivity;
        this.loginModel = loginModel;
        this.eventBus = eventBus;

    }

    @Override
    public void onCreate() {
        Log.d("Login presenter", "tudo ok");
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Subscribe
    public void error(Integer errorMessage){
        loginActivity.messageSnack(errorMessage);
        loginActivity.stopLoading();
    }

    @Subscribe
    public void receiveToken(TokenResponse token){
        if(!loginModel.setToken(token))
            loginActivity.messageSnack(R.string.username_or_password_incorrect);
        else {
            loginActivity.startActivity(new Intent(loginActivity, HomeActivity.class));
            loginActivity.stopLoading();
        }
    }

    public void login(String username, String password) {
        EnumUserPassValidator validator = loginModel.startLogin( username,  password);
        if(!validator.equals(EnumUserPassValidator.OK))
            if(validator.equals(EnumUserPassValidator.PASSWORD))
                loginActivity.passwordError(validator.getVal());
            else
                loginActivity.usernameError(validator.getVal());
        else
            loginActivity.startLoading();
    }
}
