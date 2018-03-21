package com.example.gustavobarbosab.minhassenhas.helper;

import android.content.Context;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by gustavobarbosab on 19/03/18.
 */

public class AKSHelper {

    private KeyStore keyStore;

    public AKSHelper() throws KeyStoreException {
        keyStore = KeyStore.getInstance("AndroidKeyStore");
    }

    public KeyStore build() {
        try {
            keyStore.load(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return keyStore;
    }

    public void deleteKey(String key){
        try {
            keyStore.deleteEntry(key);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }
}
