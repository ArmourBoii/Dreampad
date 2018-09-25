package com.learn.dreampad.dreampad.screenTestHome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.dreampad.dreampad.Eyetest.EyeTestSelection;
import com.learn.dreampad.dreampad.Login;
import com.learn.dreampad.dreampad.R;

public class screenTestHome extends AppCompatActivity {
    TextView EyeTest, RespondTest,VoiceTest;
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
        setContentView(R.layout.activity_screen_test_home);
        EyeTest = (TextView)findViewById(R.id.eyeTest);
        RespondTest = (TextView)findViewById(R.id.respondTest);
        VoiceTest = (TextView)findViewById(R.id.voiceTest);

        // EyeTest button press
        EyeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(screenTestHome.this,EyeTestSelection.class);
                startActivity(intent);
                finish();



            }
        });
        // RespondTest button press
        RespondTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(screenTestHome.this,EyeTestSelection.class);
//                startActivity(intent);




            }
        });
        // VoiceTest button press
        VoiceTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(screenTestHome.this,EyeTestSelection.class);
//                startActivity(intent);




            }
        });
    }
}
