package com.example.webonise.loginapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editEmail;
    EditText editPassword;

    Button btnLogin;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        String emailText=editEmail.getText().toString();
        String passwordText=editPassword.getText().toString();

        switch (v.getId()){
            case R.id.btnLogin:
                validateEmailandPassword();
                break;
            case R.id.btnSignup:
                Intent intentSignup=new Intent(this,SignUpActivity.class);
                startActivity(intentSignup);
                break;
            default:
                break;
        }
    }

    private void validateEmailandPassword() {

        Toast toast;
        if (editEmail.getText().toString().trim().isEmpty() || editPassword.getText().toString().trim().isEmpty()){
            toast=Toast.makeText(getApplicationContext(),"Enter Email and Password",Toast.LENGTH_LONG);
            toast.show();
        }else {
            Intent intentHome=new Intent(this,HomeActivity.class);
            startActivity(intentHome);
            editEmail.setText("");
            editPassword.setText("");
        }
    }
}
