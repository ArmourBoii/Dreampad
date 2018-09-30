package com.learn.dreampad.dreampad.voiceTesting;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.dreampad.dreampad.R;

import java.io.IOException;
import java.io.InputStream;

public class VoiceTestDisplayAnalysedData extends AppCompatActivity {
    //add the sinhala dictionary here


    //initiallize meaningful,non-meaningful parameters here
    TextView wordsCaptured;
    TextView sentence, meaningfuls;
    private Button repetitiveWords;

    int meaningfulWords=0;

    //Styling for double press back button
    private static long back_pressed;
    ImageView backButton;
    @Override
    public void onBackPressed() {
        finish();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_test_display_analysed_data);

        sentence = (TextView) findViewById(R.id.sentence);
        meaningfuls = (TextView) findViewById(R.id.meaningfuls);
        repetitiveWords =(Button) findViewById(R.id.repetitivewordviewbtn);
        backButton = findViewById(R.id.back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Log.println(Log.ERROR,"Hello", "InSecondPage");
        //declare text
        String text = "";
        final String capture;

        //display results

        try {
            //to read the textFile
            Log.println(Log.ERROR,"Hello", "TryTryTry");
            InputStream is = getAssets().open("dictionary.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Error","Error");
        }


        Intent intent = getIntent();
        capture = intent.getStringExtra("capture");
        sentence.setText(capture);


        //Getting meaningful word count and non-meaningful wordcount
        String wordlist[] = text.split(" ");
        String captureWords[] = capture.split(" ");
        Log.println(Log.ERROR,"err", String.valueOf(captureWords.length));

        for(int i=0; i<captureWords.length;i++)
        {
            for(int j=0; j<wordlist.length;j++)
            {
                if(wordlist[j].contains(captureWords[i]))
                {
                    meaningfulWords++;
                }
            }
        }
        meaningfuls.setText(String.valueOf(meaningfulWords));

        repetitiveWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage(capture);
            }
        });


    }
    public void goToPage(String capturedWords)
    {
        Intent startRepetitiveWordViewIntent = new Intent(this, VoiceRepetitiveWords.class);
        startRepetitiveWordViewIntent.putExtra("repetitives",capturedWords);
        startActivity(startRepetitiveWordViewIntent);

    }

}
