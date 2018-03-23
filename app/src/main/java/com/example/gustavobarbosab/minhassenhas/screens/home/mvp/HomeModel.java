package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.factory.AKSFactory;
import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;
import com.example.gustavobarbosab.minhassenhas.screens.BaseModel;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public class HomeModel implements BaseModel {

    private CompositeDisposable compositeDisposable;
    private DBFactorySite dbFactorySite;
    private ArrayList<Site> sites = new ArrayList<>();
    private AKSFactory aksFactory;

    public HomeModel(CompositeDisposable compositeDisposable, DBFactorySite dbFactorySite, AKSFactory aksFactory) {
        this.compositeDisposable = compositeDisposable;
        this.dbFactorySite = dbFactorySite;
        this.aksFactory = aksFactory;
    }

    public void saveSite(Site site) {
        String oldPass = site.getPassword();
        site.setPassword(aksFactory.encryptText(oldPass));
        this.sites.add(0,site);
        dbFactorySite.createOrUpdateSite(site);
    }

    public ArrayList<Site> getAllSites(){
        this.sites.clear();
        this.sites.addAll(dbFactorySite.findAllSite());
        return sites;
    }
}
