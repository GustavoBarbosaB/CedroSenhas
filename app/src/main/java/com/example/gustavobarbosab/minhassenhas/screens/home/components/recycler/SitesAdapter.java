package com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.SharedPreferencesHelper;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.holder.BaseHolder;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.holder.SiteHolder;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.SiteActivity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class SitesAdapter extends RecyclerView.Adapter<BaseHolder> implements Serializable{

    private ArrayList<Site> sites = new ArrayList<>();
    private Context context;
    private String token;
    private String url_site = "https://dev.people.com.ai/mobile/api/v2/logo/";

    public SitesAdapter( Context context) {
        this.context = context;
        String tokenid = context.getString(R.string.token_prefId);
        this.token = SharedPreferencesHelper.getSharedPreferenceString(context,tokenid,null);
    }

    public void setSites(ArrayList<Site> sites){
        this.sites=sites;
    }

    @Override
    public SiteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*
        * Aqui foi implementado para um só tipo de item no recycler
        * mas já está preparado para o caso de receber mais que
        * um. O intuito é auxiliar em implementações futuras da
        * aplicação.
        */

        View view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.recycler_item_home,parent,false);
        return new SiteHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        Site item = sites.get(position);
        holder.bindType(item, token, url_site +item.getUrl());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, SiteActivity.class);
            intent.putExtra("SITE",item);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.sites!=null?this.sites.size():0;
    }
}
