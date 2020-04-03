package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText newUsername, newPassword;
    CheckBox showPass;
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variables to UI components
        newUsername = findViewById(R.id.newUserNameEditText);
        newPassword = findViewById(R.id.newPasswordEditText);
        showPass = findViewById(R.id.showPasswordCheckBox);
        createButton = findViewById(R.id.createUserButton);


        //Set EventHandlers
        createButton.setOnClickListener(this);
        showPass.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.showPasswordCheckBox: new ShowPassEventHandler().onCheck(showPass, newPassword);
        }

        if(newUsername.getText().toString().length() > 0 && newPassword.getText().toString().length() > 0){
            Toast.makeText(getApplicationContext(),newUsername.getText().toString()+"   "+newPassword.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    private void showPassClick(View v) {
        System.out.println("SHOW PASS CHECK WORKED");
    }
}
