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


public class MainScreen extends AppCompatActivity {
    //Initialise variables
    TextView temp, humidity, air, uv, upperBodyUnder, upperBodyBase, upperBodyOuter, lowerBodyUnder, lowerBodyBase, waterproof, airResult, uvSunglasses;
    Button getDataButton;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        //set variables to txtViews
        temp = (TextView) findViewById(R.id.tempview);
        humidity = (TextView) findViewById(R.id.txtHum);
        air = (TextView) findViewById(R.id.txtCO2);
        uv = (TextView) findViewById(R.id.txtUV);


        //validation txt boxes
        upperBodyUnder = (TextView) findViewById(R.id.txtUpperUnderLayer);
        upperBodyBase = (TextView) findViewById(R.id.txtUpperBaseLayer);
        upperBodyOuter = (TextView) findViewById(R.id.txtUpperOuterLayer);

        lowerBodyBase = (TextView) findViewById(R.id.txtLowerBaseLayer);
        lowerBodyUnder = (TextView) findViewById(R.id.txtLowerUnderLayer);

        waterproof = (TextView) findViewById(R.id.WeatherUpper);
        airResult = (TextView) findViewById(R.id.txtAir);
        uvSunglasses = (TextView) findViewById(R.id.txtUVRequired);



        //button
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
                            //gets value of item titles FireHumidity
                            String Humidity = (String) ds.child("FireHumidity").getValue();
                            //gets value of item titles FireAir
                            String Air = (String) ds.child("FireAir").getValue();
                            //gets value of item titled FireLight
                            String Light = (String) ds.child("FireLight").getValue();


                            //sends these values to textViews which have been assigned to the above variables
                            temp.setText("Temperature : " + Temperature + "°C");
                            humidity.setText("Humidity : " + Humidity + "%");
                            air.setText("Air Quality : " + Air);
                            uv.setText("Light Intensity : " + Light + " lux");




                            double TempParse = Double.parseDouble(Temperature);
                            double HumParse = Double.parseDouble(Humidity);
                            double airParse = Double.parseDouble(Air);
                            double lightParse = Double.parseDouble(Light);


                            //Validation for Temperature
                            if (TempParse<=0)
                            {
                                upperBodyUnder.setText("Under Layer : Second Skin");
                                upperBodyBase.setText("Base Layer : Thermal T-shirt");
                                upperBodyOuter.setText("Outer Layer : Insulated Jacket");

                                lowerBodyUnder.setText("Thermal Underwear");
                                lowerBodyBase.setText("Jogging Trousers");
                            }
                            if (TempParse >0 && TempParse <5)
                            {
                                upperBodyUnder.setText("Under Layer : None");
                                upperBodyBase.setText("Base Layer : Thermal T-Shirt");
                                upperBodyOuter.setText("Outer Layer : Light Jacket");


                                lowerBodyUnder.setText("Under Layer : Running Leggings");
                                lowerBodyBase.setText("Base Layer : Shorts");
                            }
                            if (TempParse >4 && TempParse <10)
                            {
                                upperBodyUnder.setText("Under Layer : None");
                                upperBodyBase.setText("Base Layer : Long Sleeve T-Shirt");
                                upperBodyOuter.setText("Outer Layer : Light Sweater");


                                lowerBodyUnder.setText("Under Layer : None");
                                lowerBodyBase.setText("Base Layer : Shorts");
                            }
                            if (TempParse >9 && TempParse <15)
                            {
                                upperBodyUnder.setText("Under Layer : None");
                                upperBodyBase.setText("Base Layer : Long Sleeve T-Shirt");
                                upperBodyOuter.setText("Outer Layer : None");


                                lowerBodyUnder.setText("Under Layer : None");
                                lowerBodyBase.setText("Base Layer : Shorts");
                            }
                            if (TempParse >14 && TempParse <20)
                            {
                                upperBodyUnder.setText("Under Layer : None");
                                upperBodyBase.setText("Base Layer : T-Shirt");
                                upperBodyOuter.setText("Outer Layer : None");


                                lowerBodyUnder.setText("Under Layer : None");
                                lowerBodyBase.setText("Base Layer : Shorts");
                            }
                            if (TempParse >19 && TempParse <25)
                            {
                                upperBodyUnder.setText("Under Layer : None");
                                upperBodyBase.setText("Base Layer : Tank Top");
                                upperBodyOuter.setText("Outer Layer : None");


                                lowerBodyUnder.setText("Under Layer : None");
                                lowerBodyBase.setText("Base Layer : Shorts");
                            }


                            //Humidity Validation
                            if (HumParse > 50)
                            {
                                waterproof.setText("Waterproof Materials : YES");
                            }

                            if (HumParse <=50)
                            {
                                waterproof.setText("Waterproof Materials : NO");
                            }


                            //Air Quality Validation
                            if (airParse >3000)
                            {
                                airResult.setText("Inhaler : YES");
                            }
                            if (airParse <3000)
                            {
                                airResult.setText("Inhaler : NO");
                            }



                            if(lightParse >999)
                            {
                                uvSunglasses.setText("Sunglasses : YES");
                            }
                            if(lightParse <1000)
                            {
                                uvSunglasses.setText("Sunglasses : NO");
                            }
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}





