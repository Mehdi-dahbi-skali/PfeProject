package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
       String usernameIntent=intent.getStringExtra("username");


        final ImageView Poste=findViewById(R.id.poste);
        final ImageView homeIcon=findViewById(R.id.homeBtn);
        final TextView username=findViewById(R.id.Showusername);

        username.setText(usernameIntent+"");
        Poste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,PostinfoActivity.class);
                startActivity(intent);
                return;
            }
        });
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,DashboardActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}