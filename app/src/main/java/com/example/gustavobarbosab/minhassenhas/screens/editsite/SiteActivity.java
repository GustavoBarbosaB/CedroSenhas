package com.example.gustavobarbosab.minhassenhas.screens.editsite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.app.MainApp;
import com.example.gustavobarbosab.minhassenhas.domain.Site;
import com.example.gustavobarbosab.minhassenhas.helper.GlideHelper;
import com.example.gustavobarbosab.minhassenhas.helper.SharedPreferencesHelper;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.dialog.HomeCreateEditDialog;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.dagger.DaggerSiteComponent;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.dagger.SiteModule;
import com.example.gustavobarbosab.minhassenhas.screens.editsite.mvp.SitePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SiteActivity extends AppCompatActivity {


    @BindView(R.id.siteViewImage)
    ImageView image;

    @BindView(R.id.siteViewPassword)
    EditText edPassword;

    @BindView(R.id.siteViewEmail)
    TextView edEmail;

    @BindView(R.id.siteViewURL)
    TextView edUrl;

    @BindView(R.id.siteViewName)
    TextView edName;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Inject
    SitePresenter sitePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSiteComponent.builder()
                .appComponent(MainApp.getComponent())
                .siteModule(new SiteModule(this))
                .build()
                .inject(this);

        configViews();
        sitePresenter.onCreate();
        getInstanceState(savedInstanceState);
        configGlide();


    }

    private void configGlide() {
        String url_site = "https://dev.people.com.ai/mobile/api/v2/logo/"+sitePresenter.getSite().getUrl();
        String tokenid = this.getString(R.string.token_prefId);
        String token = SharedPreferencesHelper.getSharedPreferenceString(this,tokenid,null);
        Glide.with(image.getContext())
                .load(GlideHelper.getUrlWithHeaders(url_site,token))
                .into(image);
    }

    @OnClick(R.id.fab)
    public void fabClick(View view){
        showDialog();
    }

    public void showDialog(){
        HomeCreateEditDialog alertDialogBuilderCreate = new HomeCreateEditDialog(this);

        alertDialogBuilderCreate.setAllViews(sitePresenter.getSite(),"Edit Site");

        alertDialogBuilderCreate.setPositiveButton("Edit",(dialog, which) -> {
            sitePresenter.editSite(alertDialogBuilderCreate.getUrl(),
                    alertDialogBuilderCreate.getName(),
                    alertDialogBuilderCreate.getEmail(),
                    alertDialogBuilderCreate.getPassword());
            finish();
        }).create().show();
    }

    private void configViews() {
        setContentView(R.layout.activity_site);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void getInstanceState(Bundle savedInstanceState) {
        Site site;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                site = null;
            } else {
                site = (Site) extras.get("SITE");
            }
        } else {
            site = (Site) savedInstanceState.getSerializable("SITE");
        }

        if (site != null) {
            sitePresenter.receiveSite(site);
        }
    }

    public void initViewsSite(String nome, String email, String password, String url){
        edName.setText(nome);
        edEmail.setText(email);
        edPassword.setText(password);
        edUrl.setText(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.site, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.site_delete) {
            sitePresenter.deleteSite();
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
