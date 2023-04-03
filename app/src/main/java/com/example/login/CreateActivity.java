package com.example.login;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        final EditText username=findViewById(R.id.usernamecreateinput);
        final EditText pwd=findViewById(R.id.pwdcreateinput);
        final EditText pwdConfirm=findViewById(R.id.pwdconfirminput);
        final Button create=findViewById(R.id.ButtonRegister);
        final TextView help=findViewById(R.id.helpbtn);
        final TextView login=findViewById(R.id.login);
        final  EditText firstname=findViewById(R.id.firstnameinput);
        final EditText lastname=findViewById(R.id.lastnameinput);
        final EditText cne=findViewById(R.id.CneInput);
        final EditText cin=findViewById(R.id.cininput);
        final EditText DateBirth = findViewById(R.id.dateBirth);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText() == null || pwd.getText() == null){
                    Toast.makeText(CreateActivity.this, "all field are requerired !!!", Toast.LENGTH_SHORT).show();
                    return;
                }


                BackendApi backendApi = RetrofitClient.getRetrofitinstance("http://192.168.1.9:3000/").create(BackendApi.class);

                // Create a JSON object with the username and password fields
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("email", username.getText().toString());
                jsonObject.addProperty("password", pwd.getText().toString());
                jsonObject.addProperty("firstName", firstname.getText().toString());
                jsonObject.addProperty("lastName", lastname.getText().toString());
                jsonObject.addProperty("dateBirth", DateBirth.getText().toString());
                jsonObject.addProperty("state", "en attente");
                jsonObject.addProperty("cin", cin.getText().toString());
                jsonObject.addProperty("cne", cne.getText().toString());

                // Send the JSON object as the request body
                Call<User> call = backendApi.CreateUser(jsonObject);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (!response.isSuccessful()){
                            Toast.makeText(CreateActivity.this, "404", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(CreateActivity.this, "Create Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CreateActivity.this,LoginActivity.class);
                        startActivity(intent);
                        return;

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(CreateActivity.this, "reques terr", Toast.LENGTH_SHORT).show();
                        Log.e(TAG,t.getMessage());
                    }
                });

                Toast.makeText(CreateActivity.this, "Created succeful!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateActivity.this,LoginActivity.class);
                startActivity(intent);
                return;
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateActivity.this, "help page !!", Toast.LENGTH_SHORT).show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateActivity.this,LoginActivity.class);
                startActivity(intent);
                return;
            }
        });

    }
}