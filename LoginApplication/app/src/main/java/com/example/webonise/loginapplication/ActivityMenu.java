package com.example.webonise.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ActivityMenu extends AppCompatActivity implements View.OnClickListener {

    TextView textInventoryInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textInventoryInfo=(TextView)findViewById(R.id.textInventoryInfo);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            InventoryClass inventory = bundle.getParcelable("inventory");
            textInventoryInfo.setText(inventory.getModel() +"\n\n" + inventory.getCategory() + "\n\n" + inventory.getQuantity());
        }

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_logout:
                    Intent intent=new Intent(this,MainActivity.class);
                    startActivity(intent);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,InventoryFormActivity.class);
        startActivity(intent);
    }
}
