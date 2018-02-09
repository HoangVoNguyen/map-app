package com.example.hoang.myassignment2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class SvActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {
        static  final LatLng svUc1 = new LatLng(-35.238582, 149.0895637);
//    static  final LatLng svUc2 = new LatLng(-35.233867, 149.087311);
    private static final float ZOOM_BY = 10.0f;
    long duration = 5000;
    float tilt = 0;
    private static final int PAN_BY = -180;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment)getFragmentManager()
                    .findFragmentById(R.id.streetviewpanorama2);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }
    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .zoom(streetViewPanorama.getPanoramaCamera().zoom + ZOOM_BY)
                .bearing(streetViewPanorama.getPanoramaCamera().bearing - PAN_BY)
                .tilt(tilt)
                .build();
        streetViewPanorama.animateTo(camera, duration);

        streetViewPanorama.setPosition(svUc1);

//        streetViewPanorama.setPosition(svUc2);
    }
}
