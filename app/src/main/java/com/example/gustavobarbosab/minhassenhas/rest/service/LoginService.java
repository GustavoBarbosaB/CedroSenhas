package com.example.gustavobarbosab.minhassenhas.rest.service;

import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.rest.api.UserApi;
import com.example.gustavobarbosab.minhassenhas.domain.TokenResponse;
import com.example.gustavobarbosab.minhassenhas.domain.User;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public class LoginService {

    private CompositeDisposable mCompositeDisposable;
    private UserApi userApi;
    private EventBus eventBus;

    public LoginService(CompositeDisposable mCompositeDisposable, UserApi userApi, EventBus eventBus) {
        this.mCompositeDisposable = mCompositeDisposable;
        this.userApi = userApi;
        this.eventBus = eventBus;
    }


    public void loginUser(User user){
        mCompositeDisposable.add(userApi.loginUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::loginResponse,this::loginError));
        Log.d(this.getClass().getName(),"Tentativa de login");
    }

    private void loginResponse(TokenResponse token) {
        Log.d(this.getClass().getName(),"OK");
        Log.d(this.getClass().getName(),token.getAccessToken());
        eventBus.post(token);
    }

    private void loginError(Throwable error) {
        Log.d(this.getClass().getName(),error.getMessage());
        eventBus.post(error.getMessage().trim().equals("HTTP 403")?
                R.string.invalidUsernameOrPAss:R.string.bemVindo);
    }

    public void registerUser(User user){
        mCompositeDisposable.add(userApi.registerUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::registerResponse,this::registerError));
        Log.d(this.getClass().getName(),"Criação de usuario!");
    }

    private void registerResponse(TokenResponse token) {
        Log.d(this.getClass().getName(),"OK");
        Log.d(this.getClass().getName(),token.getAccessToken());
        eventBus.post(R.string.usuario_criado_sucesso);
    }

    private void registerError(Throwable error) {
        Log.d(this.getClass().getName(),error.getMessage());
        eventBus.post(R.string.erro_criar_usuario);
    }
}
