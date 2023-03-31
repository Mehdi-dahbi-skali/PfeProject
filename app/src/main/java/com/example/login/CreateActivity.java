package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CreateActivity extends AppCompatActivity {
    private EditText username ;
    private EditText pwd;
    private EditText pwdConfirm;
    private Button create;
    private TextView help;
    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        username=findViewById(R.id.usernameinput);
        pwd=findViewById(R.id.pwdinput);
        pwdConfirm=findViewById(R.id.pwdconfirminput);
        create=findViewById(R.id.ButtonRegister);
        help=findViewById(R.id.helpbtn);
        login=findViewById(R.id.login);

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
                setContentView(R.layout.activity_login);
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
                setContentView(R.layout.activity_login);
            }
        });




    }
}
