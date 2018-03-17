package com.example.gustavobarbosab.minhassenhas.service;

import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.api.UserApi;
import com.example.gustavobarbosab.minhassenhas.domain.Token;
import com.example.gustavobarbosab.minhassenhas.domain.User;
import com.example.gustavobarbosab.minhassenhas.screens.login.mvp.LoginModel;

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
                .subscribe(this::handleResponse,this::handleError));
        Log.d("LOGIN SERVICE:","Tentativa de login");
    }

    private void handleResponse(Token token) {
        Log.d("LOGIN SERVICE:","OK");
        Log.d("LOGIN SERVICE:",token.getAccessToken());
        eventBus.post(token);
    }

    private void handleError(Throwable error) {
        Log.d("LOGIN SERVICE:",error.getMessage());
        eventBus.post(error);
    }
}
