package com.example.gustavobarbosab.minhassenhas.screens.editsite.mvp;

import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.SiteActivity;

/**
 * Created by gustavobarbosab on 22/03/18.
 */

public class SitePresenter implements BasePresenter{

    private SiteActivity siteActivity;
    private SiteModel siteModel;

    public SitePresenter(SiteActivity siteActivity, SiteModel siteModel) {
        this.siteActivity = siteActivity;
        this.siteModel = siteModel;
    }

    @Override
    public void onCreate() {
        Log.d("SitePresenter","Tudo ok!");
    }

    @Override
    public void onDestroy() {
        //Adicionar caso necessário
    }

    public void receiveSite(Site site) {
        Site siteDecrypt = siteModel.receiveSite(site);
        siteActivity.initViewsSite(siteDecrypt.getNome(),siteDecrypt.getEmail(),siteDecrypt.getPassword(),siteDecrypt.getUrl());
    }

    public void deleteSite() {
        siteModel.deleteSite();

    }

    public void editSite(String url, String name, String email, String password) {
        siteModel.editSite(new Site(url,name,email,password));
    }

    public Site getSite() {
        return siteModel.getSite();
    }
}
