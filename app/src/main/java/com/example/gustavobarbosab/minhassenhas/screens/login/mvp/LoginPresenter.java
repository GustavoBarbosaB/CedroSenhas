package com.example.gustavobarbosab.minhassenhas.screens.login.mvp;

import android.content.Intent;
import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Token;
import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.login.LoginActivity;

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
        eventBus.register(this);
    }

    @Override
    public void onCreate() {
        Log.d("Login presenter", "tudo ok");
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Subscribe
    public void error(String error){
        loginActivity.messageSnack(error);
    }

    @Subscribe
    public void receiveToken(Token token){
        if(!loginModel.setToken(token))
            loginActivity.messageSnack(loginActivity.getString(R.string.username_or_password_incorrect));
        else {
            eventBus.cancelEventDelivery(token);
            loginActivity.startActivity(new Intent(loginActivity, HomeActivity.class));
        }
    }

    public void login(String username, String password) {
        if(!loginModel.startLogin( username,  password))
            loginActivity.messageSnack(loginActivity.getString(R.string.invalidUsernameOrPAss));

    }
}
