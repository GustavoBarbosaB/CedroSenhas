package com.example.gustavobarbosab.minhassenhas.screens.site;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.domain.Site;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SiteActivity extends AppCompatActivity {

    //TODO refatorar e criar camadas model e presenter
    private Site site;

    @BindView(R.id.siteViewImage)
    ImageView image;

    @BindView(R.id.siteViewPassword)
    EditText password;

    @BindView(R.id.siteViewEmail)
    TextView email;

    @BindView(R.id.siteViewURL)
    TextView url;

    @BindView(R.id.siteViewName)
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        ButterKnife.bind(this);
        initViews();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                site = null;
            } else {
                site = (Site) extras.get("SITE");
            }
        } else {
            site = (Site) savedInstanceState.getSerializable("SITE");
        }

        if(site!=null){
            name.setText(site.getNome());
            email.setText(site.getEmail());
            password.setText(site.getPassword());
            url.setText(site.getUrl());
        }

    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
