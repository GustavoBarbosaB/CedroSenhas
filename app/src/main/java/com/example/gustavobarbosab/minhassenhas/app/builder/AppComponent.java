package com.example.gustavobarbosab.minhassenhas.app.builder;

import com.example.gustavobarbosab.minhassenhas.service.UserService;
import com.example.gustavobarbosab.minhassenhas.util.rx.RxScheduler;

import dagger.Component;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@PerApplication
@Component(modules = {
        NetworkModule.class,
        RxSchedulerModule.class,
        AppModule.class,
        ApiServiceModule.class
}
)
public interface AppComponent {
    RxScheduler rxSchedulers();
    UserService apiService();
}
