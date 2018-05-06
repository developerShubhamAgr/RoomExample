package com.shubham.agr.roomexample;

import android.arch.persistence.room.Room;
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
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactAdapter.onClickListner {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    ContactAdapter adapter;
    ArrayList<User> users;

    private AppDatabase db;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
            .allowMainThreadQueries()
            .build();

        fab.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: FAB Pressed");
            Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataFromDb();
    }

    private void getDataFromDb() {
        List<User> users = db.userDao().getAllUsers();


        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ContactAdapter(MainActivity.this, users,this);
        recyclerView.setAdapter(adapter);
    }

    private void initVars() {
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onClickUser(User user) {
        Log.d(TAG, "onClickUser: USER"+user.getFirstName());
        db.userDao().deleteUser(user);
    }
}
