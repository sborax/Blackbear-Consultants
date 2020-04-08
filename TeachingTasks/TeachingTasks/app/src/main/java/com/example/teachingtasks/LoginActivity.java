package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText inputPassword;
    TextView username;
    Button cancelButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize variables with UI components
        username = (TextView) findViewById(R.id.userNameText);
        inputPassword = (EditText) findViewById(R.id.newPasswordEditText);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        loginButton = (Button) findViewById(R.id.loginButton);

        //Initialize username text to the appropriate username
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        /*
        Cancel Button
        --- Event Handler ---
         */
        cancelButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent userSelectIntent = new Intent(LoginActivity.this,UserSelectActivity.class);
                LoginActivity.this.startActivity(userSelectIntent);
            }
        });

        /*
        Login Button
        --- Event Handler ---
         */
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new LoginEventHandler().onClick(username.getText().toString(), inputPassword.getText().toString());
            }
        });
    }
}
