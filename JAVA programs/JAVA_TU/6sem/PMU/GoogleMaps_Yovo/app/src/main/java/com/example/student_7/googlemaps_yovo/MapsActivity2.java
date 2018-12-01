package com.example.student_7.googlemaps_yovo;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
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

        Button tusofiaB = (Button) findViewById(R.id.tusofia);
        Button unssB = (Button) findViewById(R.id.unss);
        Button ltyB = (Button) findViewById(R.id.lty);
        Button nsaB = (Button) findViewById(R.id.nsa);

        final LatLng TUsofia = new LatLng(42.6570607, 23.3551086);
        final LatLng unss = new LatLng(42.651266, 23.3466593);
        final LatLng lty = new LatLng(42.6537179, 23.3564474);
        final LatLng nsa = new LatLng(42.6484442, 23.3466905);

        Button line = (Button) findViewById(R.id.line);
        Button polygon = (Button) findViewById(R.id.polygon);

        nsaB.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick (View v){
                mMap.setMinZoomPreference(14);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(nsa).title("НСА").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                Marker m = mMap.addMarker(markerOptions);
                m.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(nsa));
            }
        });

        tusofiaB.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick (View v){
                mMap.setMinZoomPreference(14);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(nsa).title("ТУ-София").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                Marker m = mMap.addMarker(markerOptions);
                m.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(nsa));
            }
        });

        ltyB.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick (View v){
                mMap.setMinZoomPreference(14);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(nsa).title("Лесотехнически Университет").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                Marker m = mMap.addMarker(markerOptions);
                m.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(nsa));
            }
        });

        unssB.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick (View v){
                mMap.setMinZoomPreference(14);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(nsa).title("УНСС").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

                Marker m = mMap.addMarker(markerOptions);
                m.showInfoWindow();
                mMap.moveCamera(CameraUpdateFactory.newLatLng(nsa));
            }
        });

        mMap.setMinZoomPreference(14);

        PolylineOptions plo = new PolylineOptions();
        plo.add(TUsofia);
        plo.add(unss);
        plo.color(Color.YELLOW);
        plo.geodesic(true);
        plo.startCap(new RoundCap());
        plo.width(20);
        plo.jointType(JointType.BEVEL);

        mMap.addPolyline(plo);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TUsofia));

        mMap.setMinZoomPreference(14);

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.add(TUsofia, unss, lty, nsa);
        polygonOptions.strokeJointType(JointType.ROUND);
        polygonOptions.strokeColor(Color.BLUE);
        polygonOptions.strokeWidth(10);

        mMap.addPolygon(polygonOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(unss));
    }
}
