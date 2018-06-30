package com.example.acer.goxpcare;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginSignUpPage extends FragmentActivity {

    android.support.v4.app.FragmentTransaction transaction;
    Login login;
    SignUpp signUpp;
    Button mlogin,msignup;
    int count = 0;
    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up_page);

        fragmentManager = getSupportFragmentManager();

        mlogin = findViewById(R.id.login);
        msignup = findViewById(R.id.signup);

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = new Login();
                login.referance(LoginSignUpPage.this);
//
                transaction = fragmentManager.beginTransaction();

                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
//                use addToBackStack to go
                transaction.replace(R.id.loginn, login).addToBackStack(null).commit();

            }
        });

        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpp = new SignUpp();
                signUpp.referance(LoginSignUpPage.this);
//
                transaction = fragmentManager.beginTransaction();

                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.loginn, signUpp).addToBackStack(null).commit();

            }
        });
    }
}