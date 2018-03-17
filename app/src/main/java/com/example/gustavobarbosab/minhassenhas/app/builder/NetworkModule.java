package com.example.gustavobarbosab.minhassenhas.app.builder;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@Module
public class NetworkModule {
    @Provides
    RxJava2CallAdapterFactory provideRxAdapter(){
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    GsonConverterFactory provideGsonConverter(){
        return GsonConverterFactory.create();
    }
}
