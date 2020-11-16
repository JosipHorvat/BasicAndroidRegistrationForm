package com.horvat.basicregistrationform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText edtTxtName, edtTxtSurname, edtTxtPassword, edtTextPassRepeat;
    private Button btnPickImage, btnRegister;
    private TextView txtWarnName, txtWarnSurname, txtWarnPassword, txtWarnPassRepeat;
    private Spinner countriesSpinner;
    private RadioGroup rgGender;
    private CheckBox agreement;
    private ConstraintLayout parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }


    private void initViews() {
        Log.d(TAG, "initViews: Started");
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtSurname = findViewById(R.id.edtTxtSurname);
        edtTxtPassword = findViewById(R.id.edtTxtPasword);
        edtTextPassRepeat = findViewById(R.id.edtTxtPassConfirm);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnSurname = findViewById(R.id.txtWarnSurname);
        txtWarnPassword = findViewById(R.id.txtWatnPassword);
        txtWarnPassRepeat = findViewById(R.id.txtWarnPassConfirmed);

        countriesSpinner = findViewById(R.id.spinnerCountry);

        rgGender = findViewById(R.id.rgGender);

        agreement = findViewById(R.id.cbAgreement);

        parent = findViewById(R.id.parent);
    }
}