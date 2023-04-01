package com.example.login;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView username = findViewById(R.id.loginText);
        final TextView pwd = findViewById(R.id.pwdinput);
        final Button loginbtn = findViewById(R.id.ButtonRegister);
        final TextView createbtn = findViewById(R.id.login);
        final TextView helpbtn = findViewById(R.id.helpbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString() !=null && pwd.getText() != null){
                    BackendApi backendApi = RetrofitClient.getRetrofitinstance("http://10.0.2.2:3000/").create(BackendApi.class);
                    Call<User> call = backendApi.checkUser(username.getText().toString() , pwd.getText().toString());
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "404", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                            startActivity(intent);
                            return;

                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "reques terr", Toast.LENGTH_SHORT).show();
                            Log.e(TAG,t.getMessage());
                        }
                    });
                }else {
                    Toast.makeText(LoginActivity.this, "All field are req!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "help page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,NotificationActivity.class);
                startActivity(intent);

            }
        });
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,CreateActivity.class);
                startActivity(intent);

            }
        });
    }

}