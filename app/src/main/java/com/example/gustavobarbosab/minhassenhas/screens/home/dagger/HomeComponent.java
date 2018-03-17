package com.example.gustavobarbosab.minhassenhas.screens.home.dagger;

import com.example.gustavobarbosab.minhassenhas.app.builder.AppComponent;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;

import dagger.Component;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@HomeScope
@Component(dependencies = {AppComponent.class}, modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
}
