package com.example.webonise.loginapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by webonise on 16/9/16.
 */
public class HomeActivity extends AppCompatActivity {

    TextView textHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        textHome=(TextView)findViewById(R.id.textHome);
        textHome.setText("Logged In Successfully");
    }


}
