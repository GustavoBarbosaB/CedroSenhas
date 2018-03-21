package com.example.gustavobarbosab.minhassenhas.screens.login.mvp;

import android.content.Intent;
import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.TokenResponse;
import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.login.LoginActivity;
import com.example.gustavobarbosab.minhassenhas.util.validator.EnumUserPassValidator;
import com.example.gustavobarbosab.minhassenhas.util.validator.UserPassValidator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static com.example.gustavobarbosab.minhassenhas.helper.SharedPreferencesHelper.*;

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
        initSaveEmail();

        eventBus.register(this);
    }

    public void initSaveEmail(){
        String emailId = loginActivity.getString(R.string.email_prefId);
        String email = getSharedPreferenceString(loginActivity,emailId,null);

        if(email!=null){
            //TODO checa e habilita impressão digital se existir token
            loginActivity.changeCheckBox(true);
            loginActivity.changeTextEmail(email);
        }
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
        //TODO encryptar a token aqui
        String tokenid = loginActivity.getString(R.string.token_prefId);

        setSharedPreferenceString(loginActivity,tokenid,token.getAccessToken());

        loginActivity.startActivity(new Intent(loginActivity, HomeActivity.class));
        loginActivity.stopLoading();

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

    public boolean saveEmail(String email) {
        if(UserPassValidator.getInstance().validateUser(email).equals(EnumUserPassValidator.OK)) {
            String emailId = loginActivity.getString(R.string.email_prefId);
            setSharedPreferenceString(loginActivity, emailId, email);
            return true;
        }else {
            loginActivity.messageSnack(R.string.error_invalid_email);
            loginActivity.changeCheckBox(false);
        }
        return false;
    }

    public void removeEmail() {
        String emailId = loginActivity.getString(R.string.email_prefId);
        removeSharedPreference(loginActivity,emailId);
    }
}
