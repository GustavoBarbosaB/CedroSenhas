package com.example.gustavobarbosab.minhassenhas.screens.home.recycler.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.item.BaseItem;
import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.item.SiteItem;

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
    public void bindType(BaseItem item) {
        nameSite.setText(((SiteItem)item).getNome());
        emailSite.setText(((SiteItem)item).getEmail());
        /*Picasso.with(icon.getContext())
                .load("URL aqui")
                .into(icon);*/

        /*TODO Adicionar Glide com o header correto*/
    }
}
