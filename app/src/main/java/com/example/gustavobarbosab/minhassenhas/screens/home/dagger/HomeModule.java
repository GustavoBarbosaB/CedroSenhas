package com.example.gustavobarbosab.minhassenhas.screens.home.dagger;

import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.mvp.HomeModel;
import com.example.gustavobarbosab.minhassenhas.screens.home.mvp.HomePresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 17/03/18.
 */
@Module
public class HomeModule {
    HomeActivity homeActivity;

    public HomeModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @HomeScope
    @Provides
    HomeActivity provideContext(){
        return homeActivity;
    }

    @HomeScope
    @Provides
    HomePresenter providePresenter(HomeActivity homeActivity, HomeModel homeModel){
        return new HomePresenter(homeActivity,homeModel);
    }

    @HomeScope
    @Provides
    HomeModel provideModel(DBFactorySite dbFactorySite){
        return new HomeModel(new CompositeDisposable(),dbFactorySite);
    }

    @Provides
    DBFactorySite provideDBFactorySite(HomeActivity activity){
        return DBFactorySite.init(activity.getApplicationContext());
    }

}
