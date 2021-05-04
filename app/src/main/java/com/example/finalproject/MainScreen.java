package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;




public class MainScreen extends AppCompatActivity {
    TextView temp, humidity;
    Button getData;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        temp = (TextView) findViewById(R.id.tempview);
        //humidity = (TextView) findViewById(R.id.txtHum);
        getData = (Button) findViewById(R.id.btnGetData);


        getData.setOnClickListener(v -> {
            ref = FirebaseDatabase.getInstance().getReference().child("FirebaseData").child("data").child("MZmoQyV65qhE2KF1xex");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    String Temperature = snapshot.child("FireTemperature").getValue().toString();
                    temp.setText(Temperature);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
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