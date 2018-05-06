package com.shubham.agr.roomexample;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shubham.agr.roomexample.models.User;

public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_firstName, et_lastName, et_phone;
    private Button btn_create_contact;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        initVars();

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
            .allowMainThreadQueries()
            .build();

        btn_create_contact.setOnClickListener(this);
    }

    private void initVars() {
        et_firstName = findViewById(R.id.et_fistname);
        et_lastName = findViewById(R.id.et_lastname);
        et_phone = findViewById(R.id.et_phoneNumber);

        btn_create_contact = findViewById(R.id.btn_add_contact);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_contact:
                addUserToContact();
                break;
        }
    }

    private void addUserToContact() {
        User user = new User(
            et_firstName.getText().toString(),
            et_lastName.getText().toString(),
            et_phone.getText().toString()
        );
        db.userDao().insertAll(user);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
