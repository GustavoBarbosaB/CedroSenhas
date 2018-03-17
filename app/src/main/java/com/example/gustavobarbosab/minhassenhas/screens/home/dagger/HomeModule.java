package com.example.gustavobarbosab.minhassenhas.screens.home.dagger;

import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.mvp.HomeModel;
import com.example.gustavobarbosab.minhassenhas.screens.home.mvp.HomePresenter;
import com.example.gustavobarbosab.minhassenhas.util.rx.RxScheduler;

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
    HomePresenter providePresenter(HomeActivity homeActivity, HomeModel homeModel, RxScheduler rxSchedulers){
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        return new HomePresenter(homeActivity,homeModel,compositeDisposable,rxSchedulers);
    }

    @HomeScope
    @Provides
    HomeModel provideModel(){
        return new HomeModel();
    }

}
