package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.cloud.ParticleDevice;
import io.particle.android.sdk.utils.Toaster;
import io.particle.android.sdk.cloud.exceptions.ParticleCloudException;


public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);



        Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                //code working on
                EditText textUser = (EditText) findViewById(R.id.txtUsername);
                EditText textPassword = (EditText) findViewById(R.id.txtPassword);

                try {
                    ParticleCloudSDK.getCloud().logIn("aidangoldie7@gmail.com", "Password7");
                    Activity someActivity = null;
                    Toaster.s(someActivity, "Logged in!");

                    ParticleCloudSDK.getCloud().setAccessToken("9bb912533940e7c808b191c28cd6aaaf8d12986c");

                } catch (ParticleCloudException e) {
                   // e.printStackTrace();
                }

                /*
                try {
                    ParticleCloudSDK.getCloud().logIn(textUser.getText().toString(), textPassword.getText().toString());
                    Toaster.s(someActivity, "Logged in!");

                    Toast.makeText(MainScreen.this, "logged in.",
                            Toast.LENGTH_LONG).show();  //see below to find out more
                } catch (ParticleCloudException e) {
                    e.printStackTrace();
                    Toast.makeText(MainScreen.this, "invalid",
                            Toast.LENGTH_LONG).show();  //see below to find out more
                }
*/

            //Toaster.s(someActivity, "Logged in!");
                //End of code working on

            }
        });
    }
}

/*
    Button buttonB = (Button)findViewById(R.id.button);
        buttonB.setOnClickListener(new View.OnClickListener(){
        //annonymous inner method called when buttonB clicked....
        public void onClick(View v) {

            List<ParticleDevice> devices = ParticleCloudSDK.getCloud().getDevices();
            for (ParticleDevice device : devices) {
                if (device.getName().equals("myDevice")) {
                    //doSomethingWithMyDevice(device);
                    break;
                }
            }


            ListView myList = (ListView)findViewById(R.id.myList);
            Log.d("FirstAppTag","onClick() called - scan device button");
            Toast.makeText(MainScreen.this, "scanning for devices nearby.",
                    Toast.LENGTH_LONG).show();  //see below to find out more
            //tv1.setText(new Date().toString());
        }

    }
}
*/

