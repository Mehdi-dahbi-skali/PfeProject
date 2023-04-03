package com.example.login;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        final ImageView home = findViewById(R.id.HomeIcon);
        final ImageView NotificationIcon=findViewById(R.id.NotificationIcon);
        final ImageView ProfileIcon=findViewById(R.id.ProfileIcon);

        List<Post> posts=new ArrayList<Post>();
        posts.add(new Post("mehdi","test test"));
        posts.add(new Post("mehdi2","test test"));
        posts.add(new Post("mehdi33","test test4hvcdv"));
        posts.add(new Post("mehdIIIIIi","test testcdhbcdhcb"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdpter(getApplicationContext(),posts));











        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,DashboardActivity.class);
                startActivity(intent);
                return;
            }
        });
        NotificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,NotificationActivity.class);
                startActivity(intent);
                return;
            }
        });
        ProfileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,ProfileActivity.class);
                startActivity(intent);
                return;
            }
        });

    }
}