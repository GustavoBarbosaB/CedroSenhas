package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;

import java.util.ArrayList;

/**
 * Created by gustavobarbosab on 16/03/18.
 */

public class HomePresenter implements BasePresenter{

    private HomeActivity homeActivity;
    private HomeModel homeModel;

    public HomePresenter(HomeActivity homeActivity, HomeModel homeModel) {
        this.homeActivity = homeActivity;
        this.homeModel = homeModel;
    }

    @Override
    public void onCreate() {
        Log.d("Home presenter", "tudo ok");
    }

    @Override
    public void onDestroy() {
        /*TODO implementar onDestroy Home depois*/
    }

    /**
     *
     * @param url - URL do novo site
     * @param nome - Nome do novo site
     * @param email - Email do novo site
     * @param password - Password do novo site
     */
    public void saveSite(String url, String nome, String email, String password) {
        if(!nome.isEmpty()) {
            Site site = new Site(url, nome, email, password);
            homeModel.saveSite(site);
            homeActivity.notifyChanged();
            homeActivity.showMessage("Salvo com sucesso!");
        }else
            homeActivity.showMessage(homeActivity.getString(R.string.preencher_nome));
    }

    public ArrayList<Site> getAllSites() {
        return homeModel.getAllSites();
    }
}
