package com.example.gustavobarbosab.minhassenhas.screens.login.dagger;

import com.example.gustavobarbosab.minhassenhas.app.builder.AppComponent;
import com.example.gustavobarbosab.minhassenhas.screens.login.LoginActivity;

import dagger.Component;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@LoginScope
@Component(dependencies = {AppComponent.class},modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
