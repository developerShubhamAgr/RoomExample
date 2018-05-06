package com.shubham.agr.roomexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class CreateUserActivity extends AppCompatActivity {

    EditText et_firstName, et_lastName, et_phone;
    Button btn_create_contact;

    private static final String TAG = "CreateUserActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        initVars();

        btn_create_contact.setOnClickListener(v->{
            Log.d(TAG, "onCreate: Create Contact Button Clicked");
            
        });
    }

    private void initVars() {
        et_firstName = findViewById(R.id.et_fistname);
        et_lastName = findViewById(R.id.et_lastname);
        et_phone = findViewById(R.id.et_phoneNumber);

        btn_create_contact = findViewById(R.id.btn_add_contact);
    }
}
