package com.example.gustavobarbosab.minhassenhas.rest.api;

import com.example.gustavobarbosab.minhassenhas.domain.TokenResponse;
import com.example.gustavobarbosab.minhassenhas.domain.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public interface UserApi {

    @Headers("content-type: application/json")
    @POST("login")
    Observable<TokenResponse> loginUser(@Body User user);

    @Headers("content-type: application/json")
    @POST("register")
    Observable<TokenResponse> registerUser(@Body User user);
}
