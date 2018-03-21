package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
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
}
