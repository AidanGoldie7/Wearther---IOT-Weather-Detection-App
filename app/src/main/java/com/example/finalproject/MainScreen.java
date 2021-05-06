package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;


public class MainScreen extends AppCompatActivity {
    //Initialise variables
    TextView temp, humidity;
    Button getDataButton;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //set variables to txtViews and button
        temp = (TextView) findViewById(R.id.tempview);
        humidity = (TextView) findViewById(R.id.txtHum);
        getDataButton = (Button) findViewById(R.id.btnGetData);


        //when button clicked
        getDataButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //refer to firebase database
                ref = (DatabaseReference) FirebaseDatabase.getInstance().getReference();
                //navigate to correct node, order by key and limit to the last published key
                Query lastQuery = ref.child("FirebaseData").child("data").orderByKey().limitToLast(1);


                lastQuery.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //filters through list
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            //gets value of item titled FireTemperature
                            String Temperature = (String) ds.child("FireTemperature").getValue();
                            //gets value of item titles FireHUmidity
                            String Humidity = (String) ds.child("FireHumidity").getValue();

                            //sends these values to textViews which have been assigned to the above variables
                            temp.setText("Temperature : " + Temperature);
                            humidity.setText("Humidity : " + Humidity);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        /*
        getData.setOnClickListener(v -> {
            ref = FirebaseDatabase.getInstance().getReference().child("FirebaseData").child("data").child("MZmoQyV65qhE2KF1xex");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    String Temperature = snapshot.child("tempp").getValue().toString();
                    temp.setText(Temperature);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });

        */

    }
}





       /*
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ref = FirebaseDatabase.getInstance().getReference().child("FirebaseData").child("data").child("MZmoQyV65qhE2KF1xex");
                ref.orderByKey().limitToLast(1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String FireTemperature = dataSnapshot.child("FireTemperature").getValue().toString();
                        temp.setText(FireTemperature);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        });
    }
}
*/






                //code working on
              /*  EditText textUser = findViewById(R.id.txtUsername);
                EditText textPassword = findViewById(R.id.txtPassword);

                try {
                    //ParticleCloudSDK.getCloud().logIn(textUser.getText().toString(), textPassword.getText().toString());
                    ParticleCloudSDK.getCloud().logIn("aidangoldie7@gmail.com", "Password7");
                    //Activity MainScreen;
                    Toast.makeText(MainScreen.this, "logged in!", Toast.LENGTH_LONG).show();


                    Intent HomeIntent = new Intent(MainScreen.this, HomeScreen.class);
                    startActivity(HomeIntent);
                    finish();


                } catch (ParticleCloudException e) {
                   // e.printStackTrace();
                    Toast.makeText(MainScreen.this, "credentials wrong", Toast.LENGTH_LONG).show();
                }*/

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



/*
    Button buttonB = (Button)findViewById(R.id.button);
        buttonB.setOnClickListener(new View.OnClickListener(){
        //anonymous inner method called when buttonB clicked....
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