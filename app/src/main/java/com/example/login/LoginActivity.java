package com.example.login;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {


    private TextView username;
    private TextView pwd;
    private Button loginbtn;
    private TextView helpbtn;
    private TextView createbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.loginText);
        pwd = findViewById(R.id.pwdinput);
        loginbtn = findViewById(R.id.ButtonRegister);
        createbtn = findViewById(R.id.login);
        helpbtn = findViewById(R.id.helpbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackendApi backendApi = RetrofitClient.getRetrofitinstance().create(BackendApi.class);
                Call<User> call = backendApi.checkUser(username.toString() , pwd.toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (!response.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "404", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (username.toString().equals(response.body().getName()) && pwd.toString().equals(response.body().getJob()) ){
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            setContentView(R.layout.activity_dashbord);
                            return;
                        }
                        Toast.makeText(LoginActivity.this, "wrong info", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "reques terr", Toast.LENGTH_SHORT).show();
                        Log.e(TAG,t.getMessage());
                    }
                });

            }
        });
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "help page", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_notification);

            }
        });
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_create);
            }
        });
    }

}