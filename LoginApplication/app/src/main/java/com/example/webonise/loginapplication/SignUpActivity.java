package com.example.webonise.loginapplication;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
=======
import android.support.v7.app.AppCompatActivity;
>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
<<<<<<< HEAD
import android.widget.RadioGroup;
=======
>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import io.realm.Realm;

/**
 * Created by webonise on 16/9/16.
 */
public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private final String TAG = getClass().getSimpleName();
    public static final String aplhaPattern = "([a-zA-Z]{3,30}\\s*)+";
    public static final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

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
    private EditText editAnswer;

    private Spinner spinner;
    private Button btnLogin;
    private Button btnCancel;
    private Toast toast;

    private TextInputLayout input_layout_fname, input_layout_lname, input_layout_contact, input_layout_email, input_layout_password, input_layout_confirmPassword;

    private String firstname, lastname, email, password, confirmPassword, gender, address, securityQuestion, securityAnswer, contactString;

    Realm realm;
    int contact;
    private double contactdouble;
=======
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
>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
<<<<<<< HEAD
        Log.v(TAG, "In Signup onCreate");
        realm = Realm.getDefaultInstance();
        initViews();
    }

    private void initViews() {
        spinner = (Spinner) findViewById(R.id.spinner);

        editFirstName = (EditText) findViewById(R.id.editFirstName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        editContact = (EditText) findViewById(R.id.editContact);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editConfirmPassword = (EditText) findViewById(R.id.editConfirmPassword);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editAnswer = (EditText) findViewById(R.id.editanswer);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        input_layout_fname = (TextInputLayout) findViewById(R.id.input_layout_fname);
        input_layout_lname = (TextInputLayout) findViewById(R.id.input_layout_lname);
        input_layout_contact = (TextInputLayout) findViewById(R.id.input_layout_contact);
        input_layout_email = (TextInputLayout) findViewById(R.id.input_layout_email);
        input_layout_password = (TextInputLayout) findViewById(R.id.input_layout_password);
        input_layout_confirmPassword = (TextInputLayout) findViewById(R.id.input_layout_cpassword);

        spinner=(Spinner)findViewById(R.id.spinner);

        radioGroup.setOnCheckedChangeListener(this);
=======

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

>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
        spinner.setOnItemSelectedListener(this);
        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

<<<<<<< HEAD
        // Creating adapter for spinner
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_security , android.R.layout.simple_spinner_item);
=======
        List<String> itemSpinner=new ArrayList<>();
        itemSpinner.add("What is your nick name?");
        itemSpinner.add("Who is your favourite actor?");
        itemSpinner.add("Which school you went?");
        itemSpinner.add("First pet you had?");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemSpinner);
>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
<<<<<<< HEAD
=======
        String item = parent.getItemAtPosition(position).toString();
>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
<<<<<<< HEAD
=======

>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
    }

    @Override
    public void onClick(View v) {
<<<<<<< HEAD

        switch (v.getId()) {
            case R.id.btnLogin:
                onLoginButtonClicked();
=======
        switch (v.getId()){
            case R.id.btnLogin:
                validatefName();
                validatelName();
                validateContact();
                validateEmail();
                validatePassword();
                validateAddress();
//                toHomePage();
>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
                break;
            case R.id.btnCancel:
                System.exit(0);
                break;
            default:
                break;
        }
    }

<<<<<<< HEAD
    /**
     * Get the information filled in the Form and calls ValidateProfile() and SaveToDatabase() methods
     */
    private void onLoginButtonClicked() {

        firstname = editFirstName.getText().toString();
        lastname = editLastName.getText().toString();
        contactString = editContact.getText().toString();
        email = editEmail.getText().toString();
        password = editPassword.getText().toString();
        confirmPassword = editConfirmPassword.getText().toString();
        address = editAddress.getText().toString();
        securityQuestion = spinner.getSelectedItem().toString();
        securityAnswer = editAnswer.getText().toString();

        if (!valiDateProfile()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Data", Toast.LENGTH_SHORT);
        } else {
            saveToDatabase(firstname, lastname, contact, email, password, confirmPassword, address, securityQuestion, securityAnswer);
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
        }
    }

    /**
     *
     * @param fname
     * @param lname
     * @param contact
     * @param email
     * @param password
     * @param confirmPassword
     * @param address
     * @param securityQuestion
     * @param securityAnswer
     * Takes params and store them in DB
     */
    private void saveToDatabase(final String fname, final String lname, final int contact, final String email, final String password, final String confirmPassword, final String address, final String securityQuestion, final String securityAnswer) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                UserProfile user = realm.createObject(UserProfile.class);
                user.setFname(fname);
                user.setLname(lname);
                user.setContact(contact);
                user.setEmail(email);
                user.setPassword(password);
                user.setConfirmPassword(confirmPassword);
                user.setAddress(address);
                user.setSecurityQuestion(securityQuestion);
                user.setSecurityAnswer(securityAnswer);
            }
        });
        Log.v("message", "Success on data storing");
    }

    /**
     * Validates the input fields
     * On giving empty input and incorrect information displays Error
     * @return
     */
    private boolean valiDateProfile() {

        if (firstname.trim().isEmpty()) {
            input_layout_fname.setError(getString(R.string.error_fname));
            return false;
        } else {
            input_layout_fname.setErrorEnabled(false);
        }
        if (!firstname.matches(aplhaPattern)) {
            input_layout_fname.setError(getString(R.string.error_invalid_fname));
            return false;
        } else {
            input_layout_fname.setErrorEnabled(false);
        }
        if (lastname.trim().isEmpty()) {
            input_layout_lname.setError(getString(R.string.error_lname));
            return false;
        } else {
            input_layout_lname.setErrorEnabled(false);
        }
        if (!lastname.matches(aplhaPattern)) {
            input_layout_lname.setError(getString(R.string.error_invalid_lname));
            return false;
        } else {
            input_layout_lname.setErrorEnabled(false);
        }
        if (contactString.length() > 10 || contactString.length() < 10) {
            contactdouble = Double.parseDouble(contactString);
            contact = (int) contactdouble;
            input_layout_contact.setError(getString(R.string.error_contact));
            return false;
        } else {
            input_layout_contact.setErrorEnabled(false);
        }
        if (email.trim().isEmpty()) {
            input_layout_email.setError(getString(R.string.error_email));
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }
        if (!email.matches(emailPattern)) {
            input_layout_email.setError(getString(R.string.error_invalid_email));
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }
        if (password.trim().isEmpty()) {
            input_layout_password.setError(getString(R.string.error_password));
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }
        if (confirmPassword.trim().isEmpty()) {
            input_layout_confirmPassword.setError(getString(R.string.error_cpassword));
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }

        if (!password.equals(confirmPassword)) {
            input_layout_confirmPassword.setError(getString(R.string.error_invalid_password));
            return false;
        } else {
            input_layout_confirmPassword.setErrorEnabled(false);
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
        gender = checkedRadioButton.getText().toString();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "In Signup onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "In Signup onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "In Signup onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "In Signup onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "In Signup onDestroy");
        realm.close();
=======
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

>>>>>>> 09a458e9758bfeaba29ed0707f6237c464b09b59
    }
}
