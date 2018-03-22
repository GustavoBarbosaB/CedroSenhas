package com.example.gustavobarbosab.minhassenhas.app.builder;

import android.content.Context;

import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;
import com.example.gustavobarbosab.minhassenhas.rest.api.UserApi;
import com.example.gustavobarbosab.minhassenhas.util.rx.RxScheduler;

import org.greenrobot.eventbus.EventBus;

import dagger.Component;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@PerApplication
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        RxSchedulerModule.class,
        EventBusModule.class,
        ApiModule.class,
}
)
public interface AppComponent {
    RxScheduler rxSchedulers();
    UserApi apiService();
    EventBus eventBus();
}
