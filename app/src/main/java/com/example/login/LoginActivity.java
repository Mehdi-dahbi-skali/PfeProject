package com.example.login;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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

        // Check if the user has a token stored in SharedPreferences
        if (hasToken()) {
            // User has a token, proceed to the main app screen
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString() !=null && pwd.getText() != null){
                    BackendApi backendApi = RetrofitClient.getRetrofitinstance("http://192.168.1.46:3000/").create(BackendApi.class);
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
                                Log.i("login", response.toString());
                                Toast.makeText(LoginActivity.this, "404", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            // Get the JWT token from the response
                            String token = response.body().getToken(); // Replace with the actual method to get the token from the response

                            // Store the JWT token in SharedPreferences
                            storeToken(token);

                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                            intent.putExtra("username", username.getText() + "");
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "request error", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, t.getMessage());
                        }
                    });


//                    call.enqueue(new Callback<User>() {
//                        @Override
//                        public void onResponse(Call<User> call, Response<User> response) {
//                            if (!response.isSuccessful()){
//                                Toast.makeText(LoginActivity.this, "404", Toast.LENGTH_SHORT).show();
//
//
//                                return;
//                            }
//                            Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
//                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
//                            intent.putExtra("username",username.getText()+"");
//                            startActivity(intent);
//                            return;
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<User> call, Throwable t) {
//                            Toast.makeText(LoginActivity.this, "reques terr", Toast.LENGTH_SHORT).show();
//                            Log.e(TAG,t.getMessage());
//                        }
//                    });
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

    // Function to store JWT token in SharedPreferences
    private void storeToken(String token) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.apply();
    }

    // Method to remove the JWT token from SharedPreferences
    private void removeToken() {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("token"); // Replace "token" with the actual key used to store the JWT token
        editor.apply();
    }


    // Method to check if the user has a token stored in SharedPreferences
    private boolean hasToken() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");
        return !TextUtils.isEmpty(token);
    }
}