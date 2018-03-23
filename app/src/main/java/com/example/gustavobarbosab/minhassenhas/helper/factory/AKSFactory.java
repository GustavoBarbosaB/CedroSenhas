package com.example.gustavobarbosab.minhassenhas.helper.factory;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Base64;

import com.example.gustavobarbosab.minhassenhas.helper.EncryptionHelper;

/**
 * Created by gustavobarbosab on 19/03/18.
 */

public class AKSFactory {

    private static EncryptionHelper encryptionHelper;
    private static AKSFactory instance;

    /**
     * é o alias usado para salvar e recuperar as chaves usadas
     * na criptografia do app.
     */
    private final String SAMPLE_ALIAS = "CEDROAPPSENHAS";


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private AKSFactory(Context context){
        encryptionHelper = new EncryptionHelper(context,SAMPLE_ALIAS);
    }

    public static AKSFactory getInstance(Context context)  {
        if(instance==null){
                instance = new AKSFactory(context);
        }
        return instance;
    }

    public String encryptText(String text)  {
        return encryptionHelper.encryptString(text,SAMPLE_ALIAS);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String decryptText(String text) {
        return encryptionHelper.decryptString(text,SAMPLE_ALIAS);
    }


}
