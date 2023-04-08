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
        List<Cmt> cmts=new ArrayList<Cmt>();
        List<Cmt> cmt2=new ArrayList<Cmt>();
        List<SubCmt> subcmts=new ArrayList<SubCmt>();
        List<Reactions> reactions=new ArrayList<Reactions>();
        posts.add(new Post("mehdi","test test","12",reactions,cmt2));
        posts.add(new Post("mehdi2","test test","11",reactions,cmts));
        posts.add(new Post("mehdi33","test test4hvcdv","10",reactions,cmts));
        posts.add(new Post("mehdIIIIIi","test testcdhbcdhcb","9",reactions,cmts));

        subcmts.add(new SubCmt("mehdi hdgd", "String content String content String content","1", "5", reactions));
        subcmts.add(new SubCmt("mehdi hdgd", "String content String content String content","1", "6", reactions));
        subcmts.add(new SubCmt("mehdi hdgd", "String content String content String content", "2","7", reactions));
        subcmts.add(new SubCmt("mehdi hdgd", "String content String content String content", "3","8", reactions));
        subcmts.add(new SubCmt("mehdi hdgd", "String content String content String content", "4","9", reactions));
        subcmts.add(new SubCmt("mehdi hdgd", "String content String content String content", "3","10", reactions));

        cmts.add(new Cmt("mehdIIIIIi","test testcdhbcdhcb",subcmts,"1",reactions));
        cmts.add(new Cmt("gygyg","test testcdhbcdhcb",subcmts,"2",reactions));
        cmts.add(new Cmt("vgvgvg","test testcdhbcdhcb",subcmts,"3",reactions));
        cmts.add(new Cmt("gvgvgv","test testcdhbcdhcb",subcmts,"4",reactions));

        cmt2.add(new Cmt("mehdIIIIIi","test testcdhbcdhcb",subcmts,"1",reactions));
        Intent intent = getIntent();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdpter(getApplicationContext(),posts,intent.getStringExtra("username")+""));

        BackendApi backendApi = RetrofitClient.getRetrofitinstance("http://192.168.1.9:3000/").create(BackendApi.class);
        // Create a JSON object with the username and password fields
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", "ggggg");
        // Send the JSON object as the request body
        Call<List<Post>> call = backendApi.GetPostes();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this, "404", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(DashboardActivity.this, "dddd", Toast.LENGTH_SHORT).show();
                return;
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

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