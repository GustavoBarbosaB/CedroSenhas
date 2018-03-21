package com.example.gustavobarbosab.minhassenhas.helper.factory;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.helper.AKSHelper;

import java.lang.annotation.Target;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import static android.security.keystore.KeyProperties.*;
import static javax.crypto.Cipher.*;

/**
 * Created by gustavobarbosab on 19/03/18.
 */

public class AKSFactory {

    private AKSHelper aksHelper;

    public AKSFactory() throws KeyStoreException {
        this.aksHelper = new AKSHelper();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void createKey(String keyName) throws KeyStoreException, NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if(!aksHelper.build().containsAlias(keyName)){
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM_AES, "AndroidKeyStore");

            keyGenerator.init(new
                    KeyGenParameterSpec.Builder(keyName,
                    PURPOSE_ENCRYPT |
                            PURPOSE_DECRYPT)
                    .setBlockModes(BLOCK_MODE_CBC)
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(
                            ENCRYPTION_PADDING_PKCS7)
                    .build());
            keyGenerator.generateKey();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private Cipher createCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return getInstance(KEY_ALGORITHM_AES + "/" + BLOCK_MODE_CBC + "/" + ENCRYPTION_PADDING_PKCS7);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public Cipher createEncryptCipher(String keyName){
        SecretKey key = null;
        try {
            key = (SecretKey) aksHelper.build().getKey(keyName,
                    null);
            Cipher cipher = createCipher();
            cipher.init(ENCRYPT_MODE, key);
            return cipher;
        } catch (KeyStoreException|InvalidKeyException|NoSuchAlgorithmException|
                UnrecoverableKeyException|NoSuchPaddingException e) {
            Log.d("Failed encrypt create", e.getMessage());
        }
        return null;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private Cipher createDecryptCipher(String keyName){
        SecretKey key = null;
        try {
            key = (SecretKey) aksHelper.build().getKey(keyName,
                    null);
            Cipher cipher = createCipher();
            cipher.init(DECRYPT_MODE, key);
            return cipher;
        } catch (KeyStoreException|InvalidKeyException|NoSuchAlgorithmException|
                UnrecoverableKeyException|NoSuchPaddingException e) {
            Log.d("Failed decrypt create", e.getMessage());
        }
        return null;
    }



}
