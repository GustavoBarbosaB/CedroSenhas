package com.example.gustavobarbosab.minhassenhas.app.builder;

import com.example.gustavobarbosab.minhassenhas.rest.api.UserApi;
import com.example.gustavobarbosab.minhassenhas.util.rx.RxScheduler;

import org.greenrobot.eventbus.EventBus;

import dagger.Component;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@PerApplication
@Component(modules = {
        NetworkModule.class,
        RxSchedulerModule.class,
        EventBusModule.class,
        ApiModule.class,
        AppModule.class,
}
)
public interface AppComponent {
    RxScheduler rxSchedulers();
    UserApi apiService();
    EventBus eventBus();
}
