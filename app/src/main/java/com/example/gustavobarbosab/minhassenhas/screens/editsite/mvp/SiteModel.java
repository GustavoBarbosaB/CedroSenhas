package com.example.gustavobarbosab.minhassenhas.screens.editsite.mvp;

import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.factory.AKSFactory;
import com.example.gustavobarbosab.minhassenhas.helper.factory.DBFactorySite;

/**
 * Created by gustavobarbosab on 22/03/18.
 */

public class SiteModel {
    private DBFactorySite dbFactorySite;
    private AKSFactory aksFactory;
    private Site site;

    public SiteModel(DBFactorySite dbFactorySite,AKSFactory aksFactory) {
        this.dbFactorySite = dbFactorySite;
        this.aksFactory = aksFactory;
    }

    public Site receiveSite(Site site){
        this.site=site;
        return getSite();
    }

    public void deleteSite(){
        dbFactorySite.deleteSite(site);
    }


    public Site getSite() {
        Site noCryptSite = new Site(site.getUrl(),
                                    site.getNome(),
                                    site.getEmail(),
                                    site.getPassword());

        String password = aksFactory.decryptText(site.getPassword());

        noCryptSite.setPassword(password);

        return noCryptSite;
    }

    public void editSite(Site noCryptSite) {
        String oldPass = noCryptSite.getPassword();
        noCryptSite.setPassword(aksFactory.encryptText(oldPass));
        site.setPassword(noCryptSite.getPassword());
        site.setUrl(noCryptSite.getUrl());
        site.setNome(noCryptSite.getNome());
        site.setEmail(noCryptSite.getEmail());
        dbFactorySite.createOrUpdateSite(site);
    }
}
