package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText inputPassword;
    TextView username;
    Button cancel, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize variables with UI components
        username = (TextView) findViewById(R.id.userNameText);
        inputPassword = (EditText) findViewById(R.id.newPasswordEditText);
        cancel = (Button) findViewById(R.id.cancelButton);
        login = (Button) findViewById(R.id.loginButton);

        //Initialize username text to the appropriate username
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        
    }
}
