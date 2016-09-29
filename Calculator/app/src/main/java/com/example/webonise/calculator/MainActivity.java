package com.example.webonise.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String toastMessage = "Operation Done";
    private EditText editText1;
    private EditText editText2;
    private RadioButton radioButtonAdd;
    private RadioButton radioButtonSubtract;
    private RadioButton radioButtonMultiply;
    private RadioButton radioButtonDivide;
    private RadioGroup radioGroup;
    private Button btnCalculate;
    private TextView txtViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
        initButtonViews();
        initRadioViews();
    }

    private void initRadioViews() {
        radioButtonAdd = (RadioButton) findViewById(R.id.radioButtonAdd);
        radioButtonSubtract = (RadioButton) findViewById(R.id.radioButtonSubtract);
        radioButtonMultiply = (RadioButton) findViewById(R.id.radioButtonMultiply);
        radioButtonDivide = (RadioButton) findViewById(R.id.radioButtonDivide);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    private void initTextViews() {
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        txtViewResult = (TextView) findViewById(R.id.txtViewResult);
    }

    private void initButtonViews() {
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculate:
                double result;
                double number1, number2;
                number1 = Double.parseDouble(editText1.getText().toString());
                number2 = Double.parseDouble(editText2.getText().toString());

                Toast toast = Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG);
                toast.show();
                if (radioButtonAdd.isChecked()) {
                    result = number1 + number2;
                    txtViewResult.setText(String.valueOf(result));
                } else if (radioButtonSubtract.isChecked()) {
                    result = number1 - number2;
                    txtViewResult.setText(String.valueOf(result));
                } else if (radioButtonMultiply.isChecked()) {
                    result = number1 * number2;
                    txtViewResult.setText(String.valueOf(result));
                } else if (radioButtonDivide.isChecked()) {
                    result = number1 / number2;
                    txtViewResult.setText(String.valueOf(result));
                }
                break;
            default:
                break;
        }
    }
}
