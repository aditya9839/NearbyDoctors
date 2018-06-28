package com.example.acer.goxpcare;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Welcome extends FragmentActivity {

    static int SPLASH_TIME_OUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

//        new Handler().postDelayed(new Runnable(){
//
//            @Override
//            public void run() {
//                Intent homeIntent = new Intent(Welcome.this,MainActivity.class);
//                startActivity(homeIntent);
//                finish();
//            }
//        },SPLASH_TIME_OUT);
//    }
    }
}
