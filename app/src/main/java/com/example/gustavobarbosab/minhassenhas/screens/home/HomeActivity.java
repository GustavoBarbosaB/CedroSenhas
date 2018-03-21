package com.example.gustavobarbosab.minhassenhas.screens.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.app.MainApp;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.dialog.HomeCreateEditDialog;
import com.example.gustavobarbosab.minhassenhas.screens.home.dagger.DaggerHomeComponent;
import com.example.gustavobarbosab.minhassenhas.screens.home.dagger.HomeModule;
import com.example.gustavobarbosab.minhassenhas.screens.home.mvp.HomePresenter;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.recycler.SitesAdapter;

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

    private AlertDialog alertDialogCreate;

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
        configRecycler();
        homePresenter.onCreate();

    }

    private void configRecycler() {
        adapter = homePresenter.mockAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager mLayout= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);
    }



    public void configViews(){
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);


        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        initAlertDialogCreate();
    }

    private void initAlertDialogCreate() {
        HomeCreateEditDialog alertDialogBuilder = new HomeCreateEditDialog(this);
        alertDialogBuilder.setPositiveButtonCreate();
        alertDialogCreate= alertDialogBuilder.create();
    }

    @OnClick(R.id.fab)
    public void fabClick(View view){
       alertDialogCreate.show();
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
            case R.id.nav_camera:
                Toast.makeText(this, "Camera clicado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(this, "Gallery clicado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_slideshow:
                Toast.makeText(this, "Slide clicado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_manage:
                Toast.makeText(this, "Manager clicado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share clicado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send clicado", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
