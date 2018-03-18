package com.example.gustavobarbosab.minhassenhas.screens.login.dagger;

import com.example.gustavobarbosab.minhassenhas.rest.api.UserApi;
import com.example.gustavobarbosab.minhassenhas.screens.login.LoginActivity;
import com.example.gustavobarbosab.minhassenhas.screens.login.mvp.LoginModel;
import com.example.gustavobarbosab.minhassenhas.screens.login.mvp.LoginPresenter;
import com.example.gustavobarbosab.minhassenhas.rest.service.LoginService;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@Module
public class LoginModule {
    LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @LoginScope
    @Provides
    LoginActivity provideContext(){
        return loginActivity;
    }

    @LoginScope
    @Provides
    LoginService provideServiceLogin(EventBus eventBus, UserApi userApi){
        return new LoginService(new CompositeDisposable(),userApi,eventBus);
    }

    @LoginScope
    @Provides
    LoginModel provideModel(LoginService loginService){
        return new LoginModel(loginService);
    }

    @LoginScope
    @Provides
    LoginPresenter providePresenter(LoginActivity loginActivity, LoginModel loginModel, EventBus eventBus){
        return new LoginPresenter(loginActivity,loginModel,eventBus);
    }
}
