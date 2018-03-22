package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import com.example.gustavobarbosab.minhassenhas.screens.BaseModel;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.SitesAdapter;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.BaseItem;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.SiteItem;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 17/03/18.
 */

public class HomeModel implements BaseModel {
    private CompositeDisposable compositeDisposable;

    public SitesAdapter mockAdapter(HomeActivity activity) {
        //TODO remover o mock
        ArrayList<BaseItem> sites = new ArrayList<>();
        sites.add(new SiteItem("","Google","gustavo@hotmail.com",""));
        sites.add(new SiteItem("","Facebook","gustavoates@okmail.com",""));
        sites.add(new SiteItem("","Gmail","gustavoanto@gmail.com",""));
        sites.add(new SiteItem("","Deezer","gustavotiao@femail.com",""));
        return new SitesAdapter(sites,activity);
    }
}
