package com.example.webonise.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class InventoryFormActivity extends AppCompatActivity implements View.OnClickListener {

    private Realm realm;
    private EditText editmodel;
    private Spinner spinnerCategory;
    private EditText editquantity;
    private Button btnSave;
    private TextView textInfo;

    private int model,quantity;
    private String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_form);
        realm = Realm.getDefaultInstance();
        initViews();

        List<String> itemSpinner=new ArrayList<>();
        itemSpinner.add("Mobile");
        itemSpinner.add("Laptop");
        itemSpinner.add("Desktop");
        itemSpinner.add("Accessories");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemSpinner);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnerCategory.setAdapter(dataAdapter);


    }

    private void initViews() {
        editmodel=(EditText)findViewById(R.id.editmodel);
        editquantity=(EditText)findViewById(R.id.editquantity);

        spinnerCategory=(Spinner)findViewById(R.id.spinnerCategory);
        btnSave=(Button)findViewById(R.id.btnSave);

        textInfo=(TextView)findViewById(R.id.textInfo);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnSave:
//                model=Integer.parseInt(editmodel.getText().toString().trim());
//                category=spinnerCategory.getSelectedItem().toString();
//                quantity=Integer.parseInt(editquantity.getText().toString().trim());

                saveToDatabase( model=Integer.parseInt(editmodel.getText().toString().trim()),
                        category=spinnerCategory.getSelectedItem().toString(),
                        quantity=Integer.parseInt(editquantity.getText().toString().trim()));
                getFromDatabase();
//                break;
//            default:
//                break;
//        }
    }
//        Intent intent=new Intent();
//        Bundle bundle=new Bundle();
//        intent.putExtras(bundle);
//        intent.setClass(this,ActivityMenu.class);
//        startActivity(intent);
    private void getFromDatabase() {
        InventoryClass inventoryResult = realm.where(InventoryClass.class).findFirst();
        String output="";
            output += inventoryResult.toString();
        textInfo.setText(output);
    }

    private void saveToDatabase(final int model, final String category, final int quantity) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                InventoryClass inventory = realm.createObject(InventoryClass.class);
                inventory.setModel(model);
                inventory.setCategory(category);
                inventory.setQuantity(quantity);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("message","----Success----");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("message",error.getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
