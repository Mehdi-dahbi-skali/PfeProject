package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DasbordActivity extends AppCompatActivity {
    private ImageView HomeBtn;
    private ImageView NotificationBtn;
    private ImageView ProfileBtn;
    private TextView username;
    private TextView countLike;
    private TextView cmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasbord);
        HomeBtn = findViewById(R.id.HomeIcon);
        NotificationBtn=findViewById(R.id.NotificationIcon);
        ProfileBtn=findViewById(R.id.ProfileIcon);
        username=findViewById(R.id.Username);
        countLike=findViewById(R.id.count);
        cmt =findViewById(R.id.cmt);

        HomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_dasbord);
            }
        });
        NotificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_notification);
            }
        });
        ProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_profile);
            }
        });
        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_profile);
            }
        });
        countLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.fragment_reaction);
            }
        });
        cmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.fragment_commentaire);
            }
        });

    }
}