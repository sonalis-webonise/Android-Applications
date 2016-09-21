package com.example.webonise.loginapplication;

import android.content.DialogInterface;
import android.content.Intent;
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

    private final String TAG=getClass().getSimpleName();

    Realm realm;
    private EditText editEmail;
    private EditText editPassword;

    private Button btnLogin;
    private Button btnSignup;
    private String emailText;
    private String passwordText;
    Toast toast;

    public boolean login_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm=Realm.getDefaultInstance();
        Log.v(TAG,"In Login onCreate");
        initViews();
    }

    private void initViews(){

        editEmail=(EditText)findViewById(R.id.editEmail);
        editPassword=(EditText)findViewById(R.id.editPassword);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        emailText=editEmail.getText().toString();
        passwordText=editPassword.getText().toString();
        switch (v.getId()){
            case R.id.btnLogin:
                onLoginClick();
                break;
            case R.id.btnSignup:
                Intent intentSignup=new Intent(this,SignUpActivity.class);
                startActivity(intentSignup);
                break;
            default:
                break;
        }
    }

    private void onLoginClick() {
        String getEmail;
        String getpassword;
        if (editEmail.getText().toString().trim().isEmpty()) {
            editEmail.setError("Enter Email Id");
            return;
        }
        if (editPassword.getText().toString().trim().isEmpty()) {
            editPassword.setError("Enter password");
            return;
        }
        RealmResults<UserProfile> user = realm.where(UserProfile.class).findAll();

//        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setMessage("Enter Valid Email Id and Password")
//                .setPositiveButton("OK",null);
//        AlertDialog alert = builder.create();

        for (UserProfile userProfile : user) {
            getEmail = userProfile.getEmail();
            getpassword=userProfile.getPassword();
            if (getEmail.equals(emailText) && getpassword.equals(passwordText)) {
//                alert.show();
                Intent intentHome = new Intent(this, ActivityMenu.class);
                startActivity(intentHome);

            }
            else{
                if (!getEmail.equals(emailText)){
                    editEmail.setError("Enter Valid Mail Id");
                }
                if (!getpassword.equals(passwordText)){
                    editPassword.setError("Enter Correct Password");
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"In Login onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"In Login onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"In Login onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"In Login onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"In Login onDestroy");
    }
}
