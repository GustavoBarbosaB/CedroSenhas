package com.example.gustavobarbosab.minhassenhas.api;

import com.example.gustavobarbosab.minhassenhas.domain.Token;
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
    Observable<Token> loginUser(@Body User user);

    @Headers("content-type: application/json")
    @POST("register")
    Observable<Token> registerUser(@Body User user);
}
