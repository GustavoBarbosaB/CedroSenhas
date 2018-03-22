package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.dialog.HomeCreateEditDialog;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.SitesAdapter;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.BaseItem;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.SiteItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            homeActivity.notifyDataChanged();
        }//TODO checagem para ver se o nome é vazio
    }

    public void editSite(String url, String name, String email, String password) {
    }

    public ArrayList<Site> getAllSites() {
        return homeModel.getAllSites();
    }
}
