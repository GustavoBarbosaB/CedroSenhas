package com.example.gustavobarbosab.minhassenhas.app.builder;

import com.example.gustavobarbosab.minhassenhas.util.rx.RxScheduler;
import com.example.gustavobarbosab.minhassenhas.util.rx.impl.AppRxScheduler;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@Module
class RxSchedulerModule {
    @Provides
    RxScheduler provideRxSchedulers() {
        return new AppRxScheduler();
    }
}
