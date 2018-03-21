package com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item;

import com.example.gustavobarbosab.minhassenhas.domain.Site;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class SiteItem extends Site implements BaseItem {

    public SiteItem(String url, String nome, String email, String password) {
        super(url, nome, email, password);
    }

    @Override
    public int getListItem() {
        return BaseItem.SITE;
    }
}
