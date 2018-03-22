package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;
import com.example.gustavobarbosab.minhassenhas.screens.BaseModel;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.SitesAdapter;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.BaseItem;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.SiteItem;

import java.util.ArrayList;
import java.util.List;

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

  /*  public SitesAdapter mockAdapter(HomeActivity activity) {
        //TODO remover o mock
        ArrayList<BaseItem> sites = new ArrayList<>();
        sites.add(new SiteItem("","Google","gustavo@hotmail.com",""));
        sites.add(new SiteItem("","Facebook","gustavoates@okmail.com",""));
        sites.add(new SiteItem("","Gmail","gustavoanto@gmail.com",""));
        sites.add(new SiteItem("","Deezer","gustavotiao@femail.com",""));
        return new SitesAdapter(sites,activity);
    }*/

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
