package com.example.gustavobarbosab.minhassenhas.screens.home.mvp;

import android.util.Log;

import com.example.gustavobarbosab.minhassenhas.screens.BasePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.util.rx.RxScheduler;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 16/03/18.
 */

public class HomePresenter implements BasePresenter{

    public HomePresenter(HomeActivity homeActivity, HomeModel homeModel) {

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
