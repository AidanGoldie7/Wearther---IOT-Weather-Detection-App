package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //STEP 1 - create a timer for how long the splashscreen will show
    //5000 = 5 SECONDS
    private static int Splash_Time_Out = 5000;


    //This section doesn't change
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_LONG).show();


        //this is the code needed to decide what activity this screen will go to
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //MainScreen.class is the main menu where the app will travel to after
                //the 5 seconds
                Intent HomeIntent = new Intent(MainActivity.this, MainScreen.class);
                startActivity(HomeIntent);
                finish();



            }

  //see below to find out more

            //starts the 5 second count
        }, Splash_Time_Out);
    }
}