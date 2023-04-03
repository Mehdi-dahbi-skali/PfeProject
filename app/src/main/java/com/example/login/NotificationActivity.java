package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        final TextView notificationbtn = findViewById(R.id.notificationbtn);

        List<Notification>notifications= new ArrayList<Notification>();
        notifications.add(new Notification("mehdIIIIIi","liked post"));
        notifications.add(new Notification("mehdIIIIIi","Commented post"));
        notifications.add(new Notification("mehdIIIIIi","liked post"));
        notifications.add(new Notification("mehdIIIIIi","liked post"));

        RecyclerView recyclerView = findViewById(R.id.recycelnotif);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NotificationnAdapter(getApplicationContext(),notifications));

        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationActivity.this,DashboardActivity.class);
                startActivity(intent);
                return;
            }
        });
    }
}