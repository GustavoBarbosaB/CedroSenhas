package com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.holder.BaseHolder;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.holder.SiteHolder;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.BaseItem;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.item.SiteItem;
import com.example.gustavobarbosab.minhassenhas.screens.site.SiteActivity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public class SitesAdapter extends RecyclerView.Adapter<BaseHolder> implements Serializable{

    private ArrayList<Site> sites;
    private Context context;


    public SitesAdapter(ArrayList<Site> sites, Context context) {
        //TODO Alterar para Base item
        this.sites = sites;
        this.context = context;
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
        holder.bindType(item);
        //TODO chamar a outra activity após criá-la e passar site
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, SiteActivity.class);
            intent.putExtra("teste",item);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.sites!=null?this.sites.size():0;
    }
}
