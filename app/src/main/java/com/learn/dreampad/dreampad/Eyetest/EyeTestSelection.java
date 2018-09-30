package com.learn.dreampad.dreampad.Eyetest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.dreampad.dreampad.Login;
import com.learn.dreampad.dreampad.R;
import com.learn.dreampad.dreampad.screenTestHome.screenTestHome;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class EyeTestSelection extends AppCompatActivity {
    TextView Random,Vegetables,Animals,Fruits,Vehicles;
    ImageView BackBtn, Helpbtn;

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
        setContentView(R.layout.activity_eye_test_selection);

        Random = (TextView)findViewById(R.id.Random_Select);
        Vegetables = (TextView)findViewById(R.id.Vegetables_Select);
        Animals = (TextView)findViewById(R.id.Animals_Select);
        Fruits = (TextView)findViewById(R.id.Fruits_Select);
        Vehicles = (TextView)findViewById(R.id.Vehicles_Select);
        BackBtn = (ImageView)findViewById(R.id.back);
        Helpbtn = (ImageView)findViewById(R.id.help);

        // Vehicles button press
        Vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestSelection.this,EyeTest.class);
                Bundle args = new Bundle();

                args.putString("Type", "Vehicles");

                intent.putExtra("bundle", args);
                startActivity(intent);
                finish();



            }
        });
        // Animals button press
        Animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestSelection.this,EyeTest.class);
                Bundle args = new Bundle();

                args.putString("Type", "Animals");

                intent.putExtra("bundle", args);
                startActivity(intent);
                finish();



            }
        });
        // Back  button press
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestSelection.this,screenTestHome.class);
                startActivity(intent);
                finish();



            }
        });
        // info  button press
        Helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EyeTestSelection.this,EyeTestInfo.class);
                startActivity(intent);
                finish();



            }
        });
    }


}
