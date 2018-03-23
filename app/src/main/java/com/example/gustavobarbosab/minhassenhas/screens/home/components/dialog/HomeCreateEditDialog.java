package com.example.gustavobarbosab.minhassenhas.screens.home.components.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Site;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tqi-udi on 21/03/18.
 */

public class HomeCreateEditDialog extends AlertDialog.Builder{

    @BindView(R.id.titleDialogSite)
    TextView siteTxtTitle;

    @BindView(R.id.siteTxtEmail)
    TextView siteTxtEmail;

    @BindView(R.id.siteTxtName)
    TextView siteTxtName;

    @BindView(R.id.siteTxtPassword)
    TextView siteTxtPassword;

    @BindView(R.id.siteTxtUrl)
    TextView siteTxtUrl;

    public HomeCreateEditDialog(@NonNull Context context) {
        super(context);
        View view = View.inflate(context,R.layout.dialog_new_edit_site,null);
        ButterKnife.bind(this,view);
        this.setView(view);

        /* When negative (No/cancel) button is clicked*/
        this.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.cancel();
        });
    }


    public AlertDialog.Builder setPositiveButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        super.setPositiveButton(text,listener);
        return this;
    }

    public String getEmail() {
        return siteTxtEmail.getText().toString();
    }


    public String getName() {
        String text = siteTxtName.getText().toString();
        if(text.isEmpty())
            siteTxtEmail.setError(getContext().getString(R.string.preencher_nome));
        return text;
    }

    public String getPassword() {
        return siteTxtPassword.getText().toString();
    }

    public String getUrl() {
        return siteTxtUrl.getText().toString();
    }

    public void setSiteTxtEmail(String siteTxtEmail) {
        this.siteTxtEmail.setText(siteTxtEmail);
    }

    public void setSiteTxtName(String siteTxtName) {
        this.siteTxtName.setText(siteTxtName);
    }

    public void setSiteTxtPassword(String siteTxtPassword) {
        this.siteTxtPassword.setText(siteTxtPassword);
    }

    public void setSiteTxtUrl(String siteTxtUrl) {
        this.siteTxtUrl.setText(siteTxtUrl);
    }

    public void setSiteTxtTitle(String siteTxtTitle) {
        this.siteTxtTitle.setText(siteTxtTitle);
    }

    public void setAllViews(Site site, String title) {
        setSiteTxtTitle(title);
        setSiteTxtEmail(site.getEmail());
        setSiteTxtUrl(site.getUrl());
        setSiteTxtPassword(site.getPassword());
        setSiteTxtName(site.getNome());
    }
}
