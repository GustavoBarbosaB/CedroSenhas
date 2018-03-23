package com.example.gustavobarbosab.minhassenhas.helper;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

/**
 * Created by gustavobarbosab on 22/03/18.
 */

public class GlideHelper {

    public static GlideUrl getUrlWithHeaders(String url, String token){
        return new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("Authorization", token)
                .build());
    }
}
