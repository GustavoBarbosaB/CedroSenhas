package com.example.gustavobarbosab.minhassenhas.screens.editsite.dagger;

import com.example.gustavobarbosab.minhassenhas.app.builder.AppComponent;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.SiteActivity;

import dagger.Component;

/**
 * Created by gustavobarbosab on 22/03/18.
 */

@SiteScope
@Component(dependencies = {AppComponent.class}, modules = {SiteModule.class})
public interface SiteComponent {
    void inject(SiteActivity siteActivity);
}
