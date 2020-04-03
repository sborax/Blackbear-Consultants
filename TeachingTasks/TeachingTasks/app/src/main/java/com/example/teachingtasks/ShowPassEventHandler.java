package com.example.teachingtasks;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.EditText;

public class ShowPassEventHandler {

    public void onCheck(CheckBox showPass, EditText pass){

        if(showPass.isChecked()) {
            pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        else {
            pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

        System.out.println("InputType: " + pass.getInputType());
    }
}
