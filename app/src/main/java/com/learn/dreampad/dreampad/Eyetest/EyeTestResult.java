package com.learn.dreampad.dreampad.Eyetest;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.dreampad.dreampad.R;

public class EyeTestResult extends AppCompatActivity {
    int pStatus = 0;
    private Handler handler = new Handler();
    TextView percentageFill, imageCount,AutisticImageCount,NonAutisticImageCount,TimeTaken;
    Button confirmBtn;
    int percentageFromBackend = 0;
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
        setContentView(R.layout.activity_eye_test_result);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressbar);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);


        confirmBtn = (Button)findViewById(R.id.retult_confirm);
        percentageFill = (TextView) findViewById(R.id.percentageProgress);
        imageCount = (TextView) findViewById(R.id.image_count);
        AutisticImageCount = (TextView) findViewById(R.id.Autistic_image_count);
        NonAutisticImageCount = (TextView) findViewById(R.id.Non_Autistic_image_count);
        TimeTaken = (TextView) findViewById(R.id.time_taken);
        String Count= getIntent().getStringExtra("Count");
        String LeftCount= getIntent().getStringExtra("LeftCount");
        String RightCount= getIntent().getStringExtra("RightCount");
        String time= getIntent().getStringExtra("time");
        double Autistic = Double.parseDouble(LeftCount);
        double NetCount = Double.parseDouble(Count);
        double percentage = (Autistic/NetCount)*100;
        Log.e("percentage", String.valueOf(percentage));
        percentageFromBackend = (int) percentage;
        Log.e("percentageFromBackend", String.valueOf(percentageFromBackend));

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < percentageFromBackend) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);
                            percentageFill.setText(pStatus + "%");

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(16); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        imageCount.setText(Count);
        AutisticImageCount.setText(LeftCount);
        NonAutisticImageCount.setText(RightCount);
        TimeTaken.setText(time);
        // confirm Button button press
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestResult.this,EyeTestSelection.class);
                startActivity(intent);
                finish();



            }
        });
    }
}
