package com.shubham.agr.roomexample;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.shubham.agr.roomexample.models.User;

public class CreateUserActivity extends AppCompatActivity {

    EditText et_firstName, et_lastName, et_phone;
    Button btn_create_contact;

    private static final String TAG = "CreateUserActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        initVars();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
            .allowMainThreadQueries()
            .build();

        btn_create_contact.setOnClickListener(v->{
            Log.d(TAG, "onCreate: Create Contact Button Clicked");

            User user = new User(
                et_firstName.getText().toString(),
                et_lastName.getText().toString(),
                et_phone.getText().toString()
            );
            db.userDao().insertAll(user);

            startActivity(new Intent(CreateUserActivity.this, MainActivity.class));
        });
    }

    private void initVars() {
        et_firstName = findViewById(R.id.et_fistname);
        et_lastName = findViewById(R.id.et_lastname);
        et_phone = findViewById(R.id.et_phoneNumber);

        btn_create_contact = findViewById(R.id.btn_add_contact);
    }
}
