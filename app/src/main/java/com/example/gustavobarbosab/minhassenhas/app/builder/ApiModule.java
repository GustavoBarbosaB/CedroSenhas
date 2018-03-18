package com.example.gustavobarbosab.minhassenhas.app.builder;

import com.example.gustavobarbosab.minhassenhas.rest.api.UserApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@Module
public class ApiModule {
    private String baseURL = "https://dev.people.com.ai/mobile/api/v2/";

    @Provides
    UserApi getChatService(RxJava2CallAdapterFactory rx, GsonConverterFactory gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(rx)
                .addConverterFactory(gson)
                .build();

        return retrofit.create(UserApi.class);
    }
}
