package com.example.teachingtasks;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EditTaskActivity extends AppCompatActivity {
    TextView username, imageDesc;
    ImageView image;
    Button taskNavButton, settingsNavButton, statisticsNavButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        Button loadImage = (Button)findViewById(R.id.new_pic_button);
        Button createTask = (Button)findViewById(R.id.create_task);
        image = (ImageView)findViewById(R.id.task_pic);
        image.setImageResource(android.R.color.transparent);

        taskNavButton = (Button) findViewById(R.id.taskNavButton);
        statisticsNavButton = (Button) findViewById(R.id.statisticsNavButton);
        settingsNavButton = (Button) findViewById(R.id.settingsNavButton);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        //TODO: Need to somehow verify input image name
        imageDesc = (TextView) findViewById(R.id.input_image_name);

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
                createUserIntent.putExtra("EXTRA_USER", username.getText().toString());
                createUserIntent.putExtra("NEW_IMAGE_DESC", imageDesc.getText().toString());

                try {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
                    Bitmap bitmap = drawable.getBitmap();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    createUserIntent.putExtra("NEW_IMAGE", byteArray);
                    startActivity(createUserIntent);
                }catch(RuntimeException exc) {
                    exc.printStackTrace();
                }
            }});

        taskNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
            }
        });

        statisticsNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
            }
        });

        settingsNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        super.onActivityResult(request, result, data);

        if (result == RESULT_OK){
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