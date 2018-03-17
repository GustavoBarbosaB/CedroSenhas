package com.example.gustavobarbosab.minhassenhas.screens.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gustavobarbosab.minhassenhas.app.MainApp;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.screens.home.dagger.HomeModule;
import com.example.gustavobarbosab.minhassenhas.screens.login.dagger.DaggerLoginComponent;
import com.example.gustavobarbosab.minhassenhas.screens.login.dagger.LoginModule;
import com.example.gustavobarbosab.minhassenhas.screens.login.mvp.LoginPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    // UI references.

    @BindView(R.id.login_progress)
    View mProgressView;

    @BindView(R.id.login_form)
    View mLoginFormView;

    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;

    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerLoginComponent.builder()
                .appComponent(MainApp.getComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        configViews();
        loginPresenter.onCreate();
    }

    public void configViews(){
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_sign_in_button)
    public void emailBtSignIn(){
        loginPresenter.login(mEmailView.getText().toString(),mPasswordView.getText().toString());
    }

    public void messageSnack(String message) {
        Snackbar.make(findViewById(R.id.login_layout), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void startActivity(Intent intent){
        super.startActivity(intent);
    }
}

