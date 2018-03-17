package com.example.gustavobarbosab.minhassenhas.screens.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.gustavobarbosab.minhassenhas.app.MainApp;
import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.screens.login.dagger.DaggerLoginComponent;
import com.example.gustavobarbosab.minhassenhas.screens.login.dagger.LoginModule;
import com.example.gustavobarbosab.minhassenhas.screens.login.mvp.LoginPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.INTERNET;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    // UI references.
    private static final int REQUEST_INTERNET_ACCESS = 0;

    @BindView(R.id.login_progress)
    ProgressBar mProgressView;

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
        mayRequestInternetAccess();
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

    public void startLoading() {
        mProgressView.setVisibility(View.VISIBLE);
    }

    public void stopLoading() {
        mProgressView.setVisibility(View.GONE);

    }

    private boolean mayRequestInternetAccess() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(INTERNET) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(INTERNET)) {
            requestPermissions(new String[]{INTERNET}, REQUEST_INTERNET_ACCESS);
        } else {
            requestPermissions(new String[]{INTERNET}, REQUEST_INTERNET_ACCESS);
        }
        return false;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_INTERNET_ACCESS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                messageSnack(getString(R.string.access));
            }
        }
    }



}

