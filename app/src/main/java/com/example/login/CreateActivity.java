package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText() != null || pwd.getText() != null){
                    Toast.makeText(CreateActivity.this, "all field are requerired !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!pwd.getText().equals(pwdConfirm.getText())){
                    Toast.makeText(CreateActivity.this, "password should be the same", Toast.LENGTH_SHORT).show();
                    return;
                }
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