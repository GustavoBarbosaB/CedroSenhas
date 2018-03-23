package com.example.gustavobarbosab.minhassenhas.screens.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.app.MainApp;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.dialog.HomeCreateEditDialog;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.SitesAdapter;
import com.example.gustavobarbosab.minhassenhas.screens.home.dagger.DaggerHomeComponent;
import com.example.gustavobarbosab.minhassenhas.screens.home.dagger.HomeModule;
import com.example.gustavobarbosab.minhassenhas.screens.home.mvp.HomePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.login.LoginActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.homeRecycler)
    RecyclerView recyclerView;

    private SitesAdapter adapter;

    @Inject
    HomePresenter homePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DaggerHomeComponent.builder()
                .appComponent(MainApp.getComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);

        configViews();
        homePresenter.onCreate();
    }

    @Override
    protected void onResume(){
        super.onResume();
        adapter.setSites(homePresenter.getAllSites());
        adapter.notifyDataSetChanged();

    }


    public void configViews(){
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);


        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        configRecycler();
    }

    private void configRecycler() {
        adapter = new SitesAdapter(this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager mLayout= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
    }


    @OnClick(R.id.fab)
    public void fabClick(View view){
        showDialog();
    }

    public void showDialog(){
        HomeCreateEditDialog alertDialogBuilderCreate = new HomeCreateEditDialog(this);

        alertDialogBuilderCreate.setPositiveButton("Save",(dialog, which) -> {
            homePresenter.saveSite(alertDialogBuilderCreate.getUrl(),
                    alertDialogBuilderCreate.getName(),
                    alertDialogBuilderCreate.getEmail(),
                    alertDialogBuilderCreate.getPassword());
        }).create().show();
    }

    public void notifyChanged(){
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_logout:
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            case R.id.nav_about:
                Toast.makeText(this, "About app", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_new_site:
                showDialog();
                break;
            case R.id.nav_manage:
                Toast.makeText(this, "Manager clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
