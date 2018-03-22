package com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.BaseItem;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.SiteItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class SiteHolder extends BaseHolder{
    @BindView(R.id.homeCardTxtNomeSite)
    TextView nameSite;
    @BindView(R.id.homeCardTxtEmailSite)
    TextView emailSite;
    @BindView(R.id.homeCardImageSite)
    ImageView icon;

    public SiteHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindType(Site item) {
        nameSite.setText(item.getNome());
        emailSite.setText(item.getEmail());
        /*Picasso.with(icon.getContext())
                .load("URL aqui")
                .into(icon);*/

        /*TODO Adicionar Glide com o header correto*/
    }
}
