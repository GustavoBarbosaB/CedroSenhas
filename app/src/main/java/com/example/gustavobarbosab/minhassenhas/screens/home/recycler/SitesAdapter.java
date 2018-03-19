package com.example.gustavobarbosab.minhassenhas.screens.home.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.holder.BaseHolder;
import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.holder.SiteHolder;
import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.item.BaseItem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class SitesAdapter extends RecyclerView.Adapter<BaseHolder> implements Serializable{

    private ArrayList<BaseItem> sites;


    public SitesAdapter(ArrayList<BaseItem> sites) {
        this.sites = sites;
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
        BaseItem item = sites.get(position);
        holder.bindType(item);
    }

    @Override
    public int getItemCount() {
        return this.sites!=null?this.sites.size():0;
    }
}
