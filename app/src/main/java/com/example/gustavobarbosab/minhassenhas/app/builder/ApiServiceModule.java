package com.example.gustavobarbosab.minhassenhas.app.builder;

import com.example.gustavobarbosab.minhassenhas.service.UserService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@Module
public class ApiServiceModule {
    private String BASEURL = "http://www.mocky.io/v2/";

    @Provides
    UserService getChatService(RxJava2CallAdapterFactory rx, GsonConverterFactory gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(rx)
                .addConverterFactory(gson)
                .build();

        return retrofit.create(UserService.class);
    }
}
