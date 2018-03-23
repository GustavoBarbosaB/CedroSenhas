package com.example.gustavobarbosab.minhassenhas.domain;

import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.helper.factory.AKSFactory;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

@DatabaseTable
public class Site implements Serializable{

    private static final long serialVersionUID = -222864131214757024L;

    @DatabaseField(columnName = "id",allowGeneratedIdInsert = true, generatedId = true)
    private int id;
    @DatabaseField(columnName = "url")
    private String url;
    @DatabaseField(columnName = "nome")
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @DatabaseField(columnName = "email")

    private String email;
    @DatabaseField(columnName = "password")
    private String password;

    /**
     * Instanciamos o aksFactory para sempre salvar a senha criptografada e nos
     * retornar a mesma sem a criptografia
      */
    public Site() {
        //ORM
    }

    public Site(String url, String nome, String email, String password) {

        this.url = url;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {
       this.password = password;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
