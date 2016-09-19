package com.example.webonise.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 16/9/16.
 */
public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private final String TAG=getClass().getSimpleName();

    private EditText editFirstName;
    private EditText editLastName;
    private EditText editContact;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editConfirmPassword;

    private RadioGroup radioGroup;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;

    private EditText editAddress;
    private EditText editanswer;

    private Spinner spinner;
    private Button btnLogin;
    private Button btnCancel;
    private Toast toast;

    private String fname,lname,email,gender,address,securityQuestion,securityAnswer;
    private Double contact;
    int contactint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Log.v(TAG,"In Signup onCreate");
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

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButtonMale=(RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale=(RadioButton)findViewById(R.id.radioButtonFemale);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnCancel=(Button)findViewById(R.id.btnCancel);

        radioGroup.setOnCheckedChangeListener(this);
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
        fname=editFirstName.getText().toString();
        lname=editLastName.getText().toString();
        contact=Double.parseDouble(editContact.getText().toString());
        contactint=contact.intValue();
        email=editEmail.getText().toString();
        address=editAddress.getText().toString();
        securityQuestion=spinner.getSelectedItem().toString();
        securityAnswer=editanswer.getText().toString();
        switch (v.getId()){
            case R.id.btnLogin:
                    Intent intent=new Intent();
                    Bundle bundle=new Bundle();
                    UserProfile user=new UserProfile(fname,lname,contactint,email,gender,address,securityQuestion,securityAnswer);
                    bundle.putParcelable("user",user);
                    intent.putExtras(bundle);
                    intent.setClass(this,HomeActivity.class);
                    startActivity(intent);
                break;
            case R.id.btnCancel:
                System.exit(0);
                break;
            default:
                break;
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton checkedRadioButton=(RadioButton)findViewById(checkedId);
        gender=checkedRadioButton.getText().toString();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"In Signup onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"In Signup onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"In Signup onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"In Signup onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"In Signup onDestroy");
    }
}
