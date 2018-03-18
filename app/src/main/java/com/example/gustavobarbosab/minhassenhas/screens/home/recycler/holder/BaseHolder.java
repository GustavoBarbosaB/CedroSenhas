package com.example.gustavobarbosab.minhassenhas.screens.home.recycler.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gustavobarbosab.minhassenhas.screens.home.recycler.item.BaseItem;

/**
 * Created by gustavobarbosab on 18/03/18.
 */

public abstract class BaseHolder extends RecyclerView.ViewHolder{

    public BaseHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindType(BaseItem item);
}
