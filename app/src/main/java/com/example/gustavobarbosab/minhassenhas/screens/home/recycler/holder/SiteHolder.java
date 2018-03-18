package com.example.gustavobarbosab.minhassenhas.screens.home.recycler.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.item.BaseItem;
import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.item.SiteItem;
import com.squareup.picasso.Picasso;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class SiteHolder extends BaseHolder{

    private TextView nameSite;
    private TextView urlSite;
    private ImageView icon;

    public SiteHolder(View itemView) {
        super(itemView);
        /*TODO criar instancia das views*/
    }

    @Override
    public void bindType(BaseItem item) {
        nameSite.setText(((SiteItem)item).getNome());
        urlSite.setText(((SiteItem)item).getUrl());
        Picasso.with(icon.getContext())
                .load("URL aqui")
                .into(icon);
        /*TODO Adicionar URL correta do serviço*/
    }
}
