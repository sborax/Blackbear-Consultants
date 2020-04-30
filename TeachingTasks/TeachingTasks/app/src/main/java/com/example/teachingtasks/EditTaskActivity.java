package com.example.teachingtasks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EditTaskActivity extends AppCompatActivity {
    ImageView image;
    Button taskNavButton, settingsNavButton, statisticsNavButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        Button loadImage = (Button)findViewById(R.id.new_pic_button);
        Button createTask = (Button)findViewById(R.id.create_task);
        image = (ImageView)findViewById(R.id.task_pic);

        loadImage.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }});

        createTask.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent createUserIntent = new Intent(EditTaskActivity.this, CreateTaskActivity.class);
                startActivity(createUserIntent);
            }});

//        taskNavButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
//            }
//        });
//
//        statisticsNavButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
//            }
//        });
//
//        settingsNavButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                image.setImageBitmap(bitmap);
            } catch (FileNotFoundException exc) {
                exc.printStackTrace();
            }
        }
    }
}