package com.horvat.basicregistrationform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    /*NOTE:
    Snackbar textView is to small for all text I am trying to show.  (line 100)
    Warning messages: txtWarnName etc. stay visible after triggered once. I can do this with Thread to hide messages after few seconds.
    ImageView is never used, and btnPickImage is showing Toast message.

    There is maybe more bugs I didnt discover, but I have made this simple app for exercise while learning android studio with java.
    If i decide to make this app better i left this notes when I come back. For now this is just a show of to friends :)

     */


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

        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Poslije cu ovo", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRegister();
            }
        });
    }




    private void initRegister() {
        Log.d(TAG, "initRegister: Started");

        if(validateData()){
            if(agreement.isChecked()){
                showSnackBar();
            }else{
                Toast.makeText(this, "You need to agree to my licence agreement ;)", Toast.LENGTH_SHORT).show();
            }

        }
    }
        // If all data is filled corectly user is going to be "registered" and snackbar is going to be showed
    private void showSnackBar(){
        Log.d(TAG, "showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnSurname.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);

        String name = edtTxtName.getText().toString();
        String surname = edtTxtSurname.getText().toString();
        String country = countriesSpinner.getSelectedItem().toString();
        String gender = "";
        switch (rgGender.getCheckedRadioButtonId()){
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender = "";
            }

            String snackText = "Name :"+ name + "\n" +
                    "Surname: "+ surname + "\n" +
                    "Gender: " + gender + "\n" +
                    "Country: " + country;

        Log.d(TAG, "show snack bar: Snack Bar Text "+ snackText);

        Snackbar.make(parent, "User registered:\n"+ snackText , Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtTxtName.setText("");
                        edtTxtSurname.setText("");
                        edtTxtPassword.setText("");
                        edtTextPassRepeat.setText("");
                    }
                }).show();

    }


        // Just a simple method to check if all data is inserted
    private boolean validateData() {
        Log.d(TAG, "validateData: Started");
        if(edtTxtName.getText().toString().equals("")){
            txtWarnName.setVisibility(View.VISIBLE);
            txtWarnName.setText("Name field is empty");
            return false;
        }
        if(edtTxtSurname.getText().toString().equals("")){
            txtWarnSurname.setVisibility(View.VISIBLE);
            txtWarnSurname.setText("Surname field is empty");
        return false;
        }
        if(edtTxtPassword.getText().toString().equals("")){
            txtWarnPassword.setVisibility(View.VISIBLE);
            txtWarnPassword.setText("Password field is empty");
            return false;
        }
        if(edtTextPassRepeat.getText().toString().equals("")){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Re-enter password");
            return false;
        }
        if(!edtTxtPassword.getText().toString().equals(edtTextPassRepeat.getText().toString()) ){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Pasword does not match");
            return false;
        }

        return true;
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