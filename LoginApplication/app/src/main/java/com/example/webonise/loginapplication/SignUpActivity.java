package com.example.webonise.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.TextInputLayout;
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

import io.realm.Realm;

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

    private TextInputLayout input_layout_fname,input_layout_lname,input_layout_contact,input_layout_email;

    private String fname,lname,email,gender,address,securityQuestion,securityAnswer,contactstr;
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

        input_layout_fname=(TextInputLayout)findViewById(R.id.input_layout_fname);
        input_layout_lname=(TextInputLayout)findViewById(R.id.input_layout_lname);
        input_layout_contact=(TextInputLayout)findViewById(R.id.input_layout_contact);
        input_layout_email=(TextInputLayout)findViewById(R.id.input_layout_email);

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

        switch (v.getId()){
            case R.id.btnLogin:
                if (!valiDateProfile()){
                    Toast toast=Toast.makeText(getApplicationContext(),"Enter Data",Toast.LENGTH_SHORT);
                }
                else {
                    Intent intent=new Intent(this,ActivityMenu.class);
//                    Bundle bundle=new Bundle();
//                    contact=Double.parseDouble(contactstr);
//                    contactint=contact.intValue();
//                    UserProfile user=new UserProfile(fname,lname,contactint,email,gender,address,securityQuestion,securityAnswer);
//                    bundle.putParcelable("user",user);
//                    intent.putExtras(bundle);
//                    intent.setClass(this,ActivityMenu.class);
                    startActivity(intent);
                }



                break;
            case R.id.btnCancel:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private boolean valiDateProfile() {
        fname=editFirstName.getText().toString();
        lname=editLastName.getText().toString();
        contactstr=editContact.getText().toString();
        email=editEmail.getText().toString();
        address=editAddress.getText().toString();
        securityQuestion=spinner.getSelectedItem().toString();
        securityAnswer=editanswer.getText().toString();

//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
////                UserProfile user = realm.createObject(UserProfile.class);
////                user.setFname(fname);
////                user.setEmail(email);
//            }
//        });

//                realm = Realm.getDefaultConfiguration();

        if (fname.trim().isEmpty()){
            input_layout_fname.setError("Enter First Name");
            return false;
        }
        else {
            input_layout_fname.setErrorEnabled(false);
        }

        if (lname.trim().isEmpty()){
            input_layout_lname.setError("Enter Last Name");
            return false;
        }
        else {
            input_layout_lname.setErrorEnabled(false);
        }

        if (contactstr.length()>10 || contactstr.length()<10){
            input_layout_contact.setError("Enter 10 Digit Contact Number");
            return false;
        }
        else {
            input_layout_contact.setErrorEnabled(false);
        }

        if (email.trim().isEmpty()){
            input_layout_email.setError("Enter Email ID");
            return false;
        }
        else {
            input_layout_email.setErrorEnabled(false);
        }
        return true;


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
