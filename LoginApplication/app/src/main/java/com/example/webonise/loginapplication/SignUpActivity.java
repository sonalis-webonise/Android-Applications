package com.example.webonise.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 16/9/16.
 */
public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    EditText editFirstName;
    EditText editLastName;
    EditText editContact;
    EditText editEmail;
    EditText editPassword;
    EditText editConfirmPassword;

    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;

    EditText editAddress;
    EditText editanswer;

    Spinner spinner;
    Button btnLogin;
    Button btnCancel;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        initViews();

    }

    private void initViews(){
        spinner=(Spinner)findViewById(R.id.spinner);

        editFirstName=(EditText)findViewById(R.id.editFirstName);
        editLastName=(EditText)findViewById(R.id.editLastName);
        editContact=(EditText)findViewById(R.id.editContact);
        editEmail=(EditText)findViewById(R.id.editEmail);
        editPassword=(EditText)findViewById(R.id.editPassword);
        editConfirmPassword=(EditText)findViewById(R.id.editConfirmPassword);
        editAddress=(EditText)findViewById(R.id.editAddress);
        editanswer=(EditText)findViewById(R.id.editanswer);

        radioButtonMale=(RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale=(RadioButton)findViewById(R.id.radioButtonFemale);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnCancel=(Button)findViewById(R.id.btnCancel);

        spinner.setOnItemSelectedListener(this);
        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        List<String> itemSpinner=new ArrayList<>();
        itemSpinner.add("What is your nick name?");
        itemSpinner.add("Who is your favourite actor?");
        itemSpinner.add("Which school you went?");
        itemSpinner.add("First pet you had?");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemSpinner);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                validatefName();
                validatelName();
                validateContact();
                validateEmail();
                validatePassword();
                validateAddress();
//                toHomePage();
                break;
            case R.id.btnCancel:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private void validatefName() {
        if (editFirstName.getText().toString().trim().isEmpty()){
            toast=Toast.makeText(getApplicationContext(),"Enter First Name",Toast.LENGTH_SHORT);
            toast.show();
        }else {
            String fname=editFirstName.getText().toString();
        }
    }

    private void validatelName() {
        if (editLastName.getText().toString().trim().isEmpty()){
            toast=Toast.makeText(getApplicationContext(),"Enter Last Name",Toast.LENGTH_SHORT);
            toast.show();
        }else {
            String lname=editLastName.getText().toString();
        }
    }

    private void validateContact() {
        if (editContact.getText().toString().trim().isEmpty()){
            toast=Toast.makeText(getApplicationContext(),"Enter Contact",Toast.LENGTH_SHORT);
            toast.show();
        }else {
            double contact;
            contact=Double.parseDouble(editContact.getText().toString());
        }
    }

    private void validateEmail() {
        if (editEmail.getText().toString().trim().isEmpty()){
            toast=Toast.makeText(getApplicationContext(),"Enter Email id",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            String email=editEmail.getText().toString();
        }

    }

    private void validatePassword() {
        if (editPassword.getText().toString().trim().isEmpty() || editConfirmPassword.getText().toString().trim().isEmpty()){
                toast=Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT);
        }

    }

    private void validateAddress() {
        if (editAddress.getText().toString().trim().isEmpty()){
            toast=Toast.makeText(getApplicationContext(),"Enter Address",Toast.LENGTH_SHORT);
        }
    }

    private void toHomePage(){
        Intent intentLogin=new Intent(this,MainActivity.class);
        startActivity(intentLogin);

    }
}
