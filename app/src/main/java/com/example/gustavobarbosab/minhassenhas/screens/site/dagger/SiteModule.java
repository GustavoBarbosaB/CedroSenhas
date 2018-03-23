package com.example.gustavobarbosab.minhassenhas.screens.site.dagger;

import com.example.gustavobarbosab.minhassenhas.helper.factory.AKSFactory;
import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.mvp.HomeModel;
import com.example.gustavobarbosab.minhassenhas.screens.site.SiteActivity;
import com.example.gustavobarbosab.minhassenhas.screens.site.mvp.SiteModel;
import com.example.gustavobarbosab.minhassenhas.screens.site.mvp.SitePresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by gustavobarbosab on 22/03/18.
 */

@Module
public class SiteModule {

    SiteActivity siteActivity;

    public SiteModule(SiteActivity siteActivity) {
        this.siteActivity = siteActivity;
    }

    @SiteScope
    @Provides
    SiteActivity provideContext(){
        return siteActivity;
    }

    @SiteScope
    @Provides
    SitePresenter providePresenter(SiteActivity siteActivity, SiteModel siteModel){
        return new SitePresenter(siteActivity,siteModel);
    }

    @SiteScope
    @Provides
    SiteModel provideModel(DBFactorySite dbFactorySite, AKSFactory aksFactory){
        return new SiteModel(dbFactorySite,aksFactory);
    }

    @SiteScope
    @Provides
    DBFactorySite provideDBFactorySite(SiteActivity activity){
        return DBFactorySite.init(activity.getApplicationContext());
    }

    @SiteScope
    @Provides
    AKSFactory provideAKSFactory(SiteActivity siteActivity){
        return AKSFactory.getInstance(siteActivity.getApplicationContext());
    }
}
