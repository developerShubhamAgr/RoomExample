package com.shubham.agr.roomexample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shubham.agr.roomexample.adapters.ContactAdapter;
import com.shubham.agr.roomexample.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    ContactAdapter adapter;
    ArrayList<User> users;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();

        users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User("Sugam ", "Pradhan " +i,"9806583297");
            users.add(user);
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ContactAdapter(users);
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: FAB Pressed");
            Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
            startActivity(intent);
        });


    }

    private void initVars() {
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
    }
}
