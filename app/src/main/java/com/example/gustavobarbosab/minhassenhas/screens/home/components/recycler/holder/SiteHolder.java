package com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.GlideHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class SiteHolder extends BaseHolder{
    @BindView(R.id.homeCardTxtNomeSite)
    TextView nameSite;
    @BindView(R.id.homeCardTxtEmailSite)
    TextView urlSite;
    @BindView(R.id.homeCardImageSite)
    ImageView icon;

    public SiteHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindType(Site item,String Token, String URL_IMAGE) {
        nameSite.setText(item.getNome());
        urlSite.setText(item.getUrl());
        Glide.with(icon.getContext())
                .load(GlideHelper.getUrlWithHeaders(URL_IMAGE,Token ))
                .into(icon);
    }
}
