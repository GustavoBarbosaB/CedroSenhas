package com.example.gustavobarbosab.minhassenhas.app.builder;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@Module
public class AppModule extends Application{

    private final Context context;

    public AppModule(Context aContext) {
        this.context = aContext;
    }

    @PerApplication
    @Provides
    Context provideAppContext() {
        return context;
    }

}
