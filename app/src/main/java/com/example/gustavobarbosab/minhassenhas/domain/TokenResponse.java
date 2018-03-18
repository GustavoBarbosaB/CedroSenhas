package com.example.gustavobarbosab.minhassenhas.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public class TokenResponse {
    
    private String type;
    @SerializedName("token")
    private String accessToken;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
