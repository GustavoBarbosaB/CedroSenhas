package com.example.gustavobarbosab.minhassenhas.screens.editsite.dagger;

import com.example.gustavobarbosab.minhassenhas.helper.factory.AKSFactory;
import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.SiteActivity;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.mvp.SiteModel;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.mvp.SitePresenter;

import dagger.Module;
import dagger.Provides;

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
