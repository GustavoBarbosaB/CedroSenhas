package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;
import com.example.gustavobarbosab.minhassenhas.screens.BaseModel;
import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public class HomeModel implements BaseModel {

    private CompositeDisposable compositeDisposable;
    private DBFactorySite dbFactorySite;
    private ArrayList<Site> sites = new ArrayList<>();

    public HomeModel(CompositeDisposable compositeDisposable, DBFactorySite dbFactorySite) {
        this.compositeDisposable = compositeDisposable;
        this.dbFactorySite = dbFactorySite;
    }


    public void saveSite(Site site) {
        sites.add(site);
        //TODO descomentar criação do site
       // dbFactorySite.createOrUpdateSite(site);
    }

    public ArrayList<Site> getAllSites(){
        //this.sites.addAll(dbFactorySite.findAllSite());
        return sites;
    }
}
