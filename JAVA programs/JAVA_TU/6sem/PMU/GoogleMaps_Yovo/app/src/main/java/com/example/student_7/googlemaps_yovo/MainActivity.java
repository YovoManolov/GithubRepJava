package com.example.student_7.googlemaps_yovo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button poi = (Button) findViewById(R.id.map);
        Button route = (Button) findViewById(R.id.poi);
        Button location = (Button) findViewById(R.id.location );

        poi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        route.setOnClickListener(new View.OnClickListener() {
            @Override     public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity2.class));
            } });

        location.setOnClickListener(new View.OnClickListener() {
            @Override     public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, location.class));
            }
        });

    }

}
