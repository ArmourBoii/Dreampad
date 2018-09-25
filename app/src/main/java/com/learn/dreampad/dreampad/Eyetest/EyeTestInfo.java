package com.learn.dreampad.dreampad.Eyetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.learn.dreampad.dreampad.R;

public class EyeTestInfo extends AppCompatActivity {
    ImageView backClick;
    Button Yesh, NO;
    //Styling for double press back button
    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            //super.onBackPressed();
            finishAffinity();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_test_info);
        backClick = (ImageView)findViewById(R.id.back);
        Yesh = (Button)findViewById(R.id.yeshClick);
        NO = (Button)findViewById(R.id.noClick);

        // back button press
        backClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestInfo.this,EyeTestSelection.class);
                startActivity(intent);
                finish();



            }
        });
        // back button press
        Yesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestInfo.this,EyeTestSelection.class);
                startActivity(intent);
                finish();



            }
        });
        // back button press
        NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestInfo.this,EyeTestSelection.class);
                startActivity(intent);
                finish();



            }
        });
    }
}
