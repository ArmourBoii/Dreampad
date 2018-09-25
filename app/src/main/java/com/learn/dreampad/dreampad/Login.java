package com.learn.dreampad.dreampad;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.dreampad.dreampad.screenTestHome.screenTestHome;

public class Login extends AppCompatActivity {
    private EditText Email;
    private  EditText Password;
    private Button Login;
    private TextView register, forgotPass;
    private ImageView imageView2;
    CoordinatorLayout coordinatorRelative;
    RelativeLayout relativeLayout;
    ProgressBar mProgressBar;
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
        setContentView(R.layout.activity_login);

        relativeLayout = (RelativeLayout)findViewById(R.id.login_relativeProgress);
        mProgressBar = (ProgressBar) findViewById(R.id.Login_progressBar);
        coordinatorRelative = (CoordinatorLayout) findViewById(R.id.main);
        Email = (EditText) findViewById(R.id.input_user_email);
        Password = (EditText) findViewById(R.id.input_password);
        Login = (Button) findViewById(R.id.btn_login );
        register = (TextView)findViewById(R.id.signUp);
        forgotPass = (TextView)findViewById(R.id.forgotPass);

        forgotPass.setText(fromHtml("<font color='#7697A2'>Forgot Passsword? </font><font color='#ffffff'> Reset</font>"));
        register.setText(fromHtml("<font color='#7697A2'>Not Registered? </font><font color='#ffffff'> Register with Us</font>"));
        // remove keyboard when press outside the keyboard
        coordinatorRelative.setOnTouchListener(new View.OnTouchListener() {
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

        // login button press
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,screenTestHome.class);
                startActivity(intent);
                finish();



            }
        });
        // register button press
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
                finish();



            }
        });

    }
    // to get colours using html css
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}
