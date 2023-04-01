package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class DashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        final TextView userProfile;
        final ImageView home = findViewById(R.id.HomeIcon);
        final ImageView NotificationIcon=findViewById(R.id.NotificationIcon);
        final ImageView ProfileIcon=findViewById(R.id.ProfileIcon);
        userProfile = findViewById(R.id.UsernameView);
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,ProfileActivity.class);
                startActivity(intent);
                return;
            }
        });
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