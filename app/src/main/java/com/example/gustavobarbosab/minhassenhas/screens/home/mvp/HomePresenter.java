package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.dialog.HomeCreateEditDialog;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.SitesAdapter;

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

    public SitesAdapter mockAdapter(){
        return homeModel.mockAdapter();
    }

    @Override
    public void onCreate() {
        Log.d("Home presenter", "tudo ok");
    }

    @Override
    public void onDestroy() {
        /*TODO implementar onDestroy Home depois*/
    }


    public void saveSite(String url, String nome, String email, String password) {
        /*TODO validar campos*/
        Site site = new Site(url,nome,email,password);
        homeActivity.showMessage(site.getNome());
    }

    public void editSite(String url, String name, String email, String password) {
    }
}
