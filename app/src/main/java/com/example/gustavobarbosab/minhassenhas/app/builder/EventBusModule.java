package com.example.gustavobarbosab.minhassenhas.app.builder;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@Module
public class EventBusModule {

    @Provides
    EventBus provideEventBus(){
        return EventBus.builder().build();
    }
}