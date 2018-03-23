package com.example.gustavobarbosab.minhassenhas.screens.login.components.dialog;

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

public class AccountDialog extends AlertDialog.Builder{

    @BindView(R.id.newAccountEmail)
    TextView accountEmail;

    @BindView(R.id.newAccountName)
    TextView accountName;

    @BindView(R.id.newAccountPassword)
    TextView accountPassword;


    public AccountDialog(@NonNull Context context) {
        super(context);
        View view = View.inflate(context,R.layout.dialog_new_account,null);
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
        return accountEmail.getText().toString();
    }


    public String getName() {
        String text = accountName.getText().toString();
        if(text.isEmpty())
            accountEmail.setError(getContext().getString(R.string.preencher_nome));
        return text;
    }

    public String getPassword() {
        return accountPassword.getText().toString();
    }

    public void setSiteTxtEmail(String siteTxtEmail) {
        this.accountEmail.setText(siteTxtEmail);
    }

    public void setSiteTxtName(String siteTxtName) {
        this.accountName.setText(siteTxtName);
    }

    public void setSiteTxtPassword(String siteTxtPassword) {
        this.accountPassword.setText(siteTxtPassword);
    }


    public void setAllViews(Site site, String title) {
        setSiteTxtEmail(site.getEmail());
        setSiteTxtPassword(site.getPassword());
        setSiteTxtName(site.getNome());
    }
}
