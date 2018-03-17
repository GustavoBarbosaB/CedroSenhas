package com.example.gustavobarbosab.minhassenhas.app;

import android.app.Application;

import com.example.gustavobarbosab.minhassenhas.app.builder.AppComponent;
import com.example.gustavobarbosab.minhassenhas.app.builder.AppModule;
import com.example.gustavobarbosab.minhassenhas.app.builder.DaggerAppComponent;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public class MainApp extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }


    public static AppComponent getComponent(){
        return component;
    }
}
