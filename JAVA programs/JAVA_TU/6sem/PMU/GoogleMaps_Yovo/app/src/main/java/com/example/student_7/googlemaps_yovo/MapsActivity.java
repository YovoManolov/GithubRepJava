package com.example.student_7.googlemaps_yovo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    float zoomvar = 0;
    LatLng SofiaCenter = new LatLng( 42.6977082,23.3218675);
    LatLng TUsofia = new LatLng( 42.6570607,23.3551086);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        Button plusZOOM = (Button) findViewById(R.id.zoomIN);
        Button minusZOOM = (Button) findViewById(R.id.zoomOUT);
        Button hybrid =  (Button)findViewById(R.id.hybridBUT);
        Button normal =  (Button)findViewById(R.id.normalBUT);
        Button satellite = (Button) findViewById(R.id.satelliteBUT);
        Button terrain = (Button) findViewById(R.id.terrainBUT);
        Button tus =  (Button) findViewById(R.id.tusBUT);

        Button back = (Button) findViewById(R.id.BACK);

        plusZOOM.setOnClickListener(new View.OnClickListener()

        {
            @Override public void onClick (View v){
                zoomvar += 1;
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });
        minusZOOM.setOnClickListener(new View.OnClickListener()

        {
            @Override public void onClick (View v){
                zoomvar -= 1;
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });

        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });


        terrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

        tus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.addMarker(new MarkerOptions().position(TUsofia).title("TU SOFIA"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(TUsofia )); mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(TUsofia);
                circleOptions.radius(25);
                circleOptions.fillColor(Color.BLUE);
                circleOptions.strokeColor(Color.RED);
                circleOptions.strokeWidth(4);

                mMap.addCircle(circleOptions);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this, MainActivity.class));
            }
        });
    }
}
