package com.example.webonise.loginapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();

    Realm realm;
    private EditText editEmail;
    private EditText editPassword;

    private Button btnLogin;
    private Button btnSignup;
    private String emailText;
    private String passwordText;

    private TextInputLayout input_layout_email,input_layout_password;
    private String email,password;
    Toast toast;

    public boolean login_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        Log.v(TAG, "In Login onCreate");
        initViews();
    }

    private void initViews() {

        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);

        input_layout_email=(TextInputLayout)findViewById(R.id.input_layout_loginEmail);
        input_layout_password=(TextInputLayout)findViewById(R.id.input_layout_loginPassword);

        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        emailText = editEmail.getText().toString();
        passwordText = editPassword.getText().toString();
        switch (v.getId()) {
            case R.id.btnLogin:
                onLoginClick();
                break;
            case R.id.btnSignup:
                Intent intentSignup = new Intent(this, SignUpActivity.class);
                startActivity(intentSignup);
                break;
            default:
                break;
        }
    }

    private void onLoginClick() {
        email=editEmail.getText().toString();
        password=editPassword.getText().toString();
        String getEmail;
        String getPassword;
        validateUser();

        RealmResults<UserProfile> user = realm.where(UserProfile.class).findAll();

//        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setMessage("Enter Valid Email Id and Password")
//                .setPositiveButton("OK",null);
//        AlertDialog alert = builder.create();

        for (UserProfile userProfile : user) {
            getEmail = userProfile.getEmail();
            getPassword = userProfile.getPassword();
            if (getEmail.equals(emailText) && getPassword.equals(passwordText)) {
//                alert.show();
                Intent intentHome = new Intent(this, ActivityMenu.class);
                startActivity(intentHome);
            } else {
                if (!getEmail.equals(emailText)) {
                    editEmail.setError("Enter Valid Mail Id");
                }
                else {
                    editEmail.clearFocus();
                }
                if (!getPassword.equals(passwordText)) {
                    editPassword.setError("Enter Correct Password");
                }
                else {
                    editPassword.clearFocus();
                }
            }
        }
    }

    private boolean validateUser() {

        if (email.trim().isEmpty()) {
            input_layout_email.setError("Enter Email Id");
            return false;
        }
        else {
            input_layout_email.setErrorEnabled(false);
        }
        if (password.trim().isEmpty()) {
            input_layout_password.setError("Enter password");
            return false;
        }
        else {
            input_layout_password.setErrorEnabled(false);
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "In Login onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "In Login onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "In Login onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "In Login onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "In Login onDestroy");
    }
}
