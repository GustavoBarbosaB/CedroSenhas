package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.util.rx.RxScheduler;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 16/03/18.
 */

public class HomePresenter implements BasePresenter{

    public HomePresenter(HomeActivity homeActivity, HomeModel homeModel,
                         CompositeDisposable compositeDisposable,
                         RxScheduler rxSchedulers) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
