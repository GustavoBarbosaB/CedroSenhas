package com.example.gustavobarbosab.minhassenhas.screens.login;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.gustavobarbosab.minhassenhas.R;
import com.example.gustavobarbosab.minhassenhas.app.MainApp;
import com.example.gustavobarbosab.minhassenhas.screens.home.HomeActivity;
import com.example.gustavobarbosab.minhassenhas.screens.home.components.dialog.HomeCreateEditDialog;
import com.example.gustavobarbosab.minhassenhas.screens.login.components.dialog.AccountDialog;
import com.example.gustavobarbosab.minhassenhas.screens.login.dagger.DaggerLoginComponent;
import com.example.gustavobarbosab.minhassenhas.screens.login.dagger.LoginModule;
import com.example.gustavobarbosab.minhassenhas.screens.login.mvp.LoginPresenter;

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

    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;

    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;

    @BindView(R.id.loginCheckSave)
    CheckBox checkBox;

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
        changeCheckBox(false);
    }



    @OnClick(R.id.login_create_account)
    public void createAccount(){
        AccountDialog dialogBuilder = new AccountDialog(this);

        dialogBuilder.setPositiveButton("Create",(dialog, which) -> {
            loginPresenter.registerUser(dialogBuilder.getName(),
                                        dialogBuilder.getEmail(),
                                        dialogBuilder.getPassword());
        }).create().show();
    }

    @OnClick(R.id.loginCheckSave)
    public void saveEmailCheck(){
        if(checkBox.isChecked()){
            loginPresenter.saveEmail(mEmailView.getText().toString());
        }else
            loginPresenter.removeEmail();
    }

    @OnClick(R.id.email_sign_in_button)
    public void emailBtSignIn(){
        loginPresenter.login(mEmailView.getText().toString(),mPasswordView.getText().toString());
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

        if (requestCode == REQUEST_INTERNET_ACCESS && grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            messageSnack(R.string.access);
        }

    }

    public void messageSnack(Integer message) {
        Snackbar.make(findViewById(R.id.login_layout), getString(message), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void usernameError(Integer msg){
        mEmailView.setError(getString(msg));
        mEmailView.setFocusable(true);
    }
    public void passwordError(Integer msg){
        mPasswordView.setError(getString(msg));
        mPasswordView.setFocusable(true);
    }

    public void startLoading() {
        mProgressView.setVisibility(View.VISIBLE);
        mEmailSignInButton.setVisibility(View.GONE);
    }

    public void stopLoading() {
        mProgressView.setVisibility(View.GONE);
        mEmailSignInButton.setVisibility(View.VISIBLE);

    }

    public void changeTextEmail(String textEmail) {
        mEmailView.setText(textEmail);
    }

    public void changeCheckBox(boolean b) {
        checkBox.setChecked(b);
    }

    public void showHomeActivity(Class<HomeActivity> activityClass) {
        Intent intent = new Intent(this,activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

