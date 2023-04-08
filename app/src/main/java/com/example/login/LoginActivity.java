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

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView username = findViewById(R.id.usernameinput);
        final TextView pwd = findViewById(R.id.pwdinput);
        final Button loginbtn = findViewById(R.id.ButtonRegister);
        final TextView createbtn = findViewById(R.id.login);
        final TextView helpbtn = findViewById(R.id.helpbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString() !=null && pwd.getText() != null){
                    BackendApi backendApi = RetrofitClient.getRetrofitinstance("http://192.168.1.9:3000/").create(BackendApi.class);
                    // Create a JSON object with the username and password fields
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("email", username.getText().toString());
                    jsonObject.addProperty("password", pwd.getText().toString());

                    // Send the JSON object as the request body
                    Call<User> call = backendApi.checkUser(jsonObject);

                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (!response.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "404", Toast.LENGTH_SHORT).show();


                                return;
                            }
                            Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                            intent.putExtra("username",username.getText()+"");
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