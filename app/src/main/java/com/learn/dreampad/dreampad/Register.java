package com.learn.dreampad.dreampad;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.dreampad.dreampad.Eyetest.EyeTest;
import com.learn.dreampad.dreampad.Eyetest.EyeTestSelection;

public class Register extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    EditText UserName, Email, ChildName,Password;
    TextView Age;
    Button SignUp;
    ImageView Add,Minus;

    int age  = 0;

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
        setContentView(R.layout.activity_register);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.register_main);
        Add = (ImageView)findViewById(R.id.plus);
        Minus = (ImageView)findViewById(R.id.minus);
        SignUp = (Button)findViewById(R.id.sign_up);
        Age = (TextView)findViewById(R.id.age);
        UserName = (EditText)findViewById(R.id.user_name);
        Email = (EditText)findViewById(R.id.user_email);
        ChildName = (EditText)findViewById(R.id.child_name);
        Password = (EditText)findViewById(R.id.password);

        // remove keyboard when press outside the keyboard
        coordinatorLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                return true;
            }
        });
        Password.setHint("PASSWORD");
        Password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (Password.getText().length() > 0)
                    Password.setHint("");
                else
                    Password.setHint("PASSWORD");
            }
        });
        // Add click for age button press
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(age <10){
                    age = age +1;
                    Age.setText(String.valueOf(age));
                    Log.e("age ---->", String.valueOf(age));
                }



            }
        });

        // minus click for age button press
        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(age >0){
                    age = age -1;
                    Age.setText(String.valueOf(age));
                    Log.e("age ---->", String.valueOf(age));
                }



            }
        });
        // SignUp click reloads back to login
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
                finish();



            }
        });

    }
}
