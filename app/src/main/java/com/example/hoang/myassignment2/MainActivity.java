package com.example.hoang.myassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;



public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        menu.getItem(0).setIcon(R.drawable.ict);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return true;
        }if (id == R.id.none) {
            mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
            return true;
        }if (id == R.id.hybrid) {
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            return true;
        }if (id == R.id.satellite) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            return true;
        }if (id == R.id.terrain) {
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//set map zoom level 15 to UC
        LatLng UC = new LatLng(-35.2381609,149.0818982);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UC, 15));
//Map loaded set center
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                moveCameraToUC();
            }
            private  void moveCameraToUC(){
//build newLatLngBounds
                LatLng n = new LatLng(-35.231185, 149.080525);
                LatLng s = new LatLng(-35.242429, 149.083462);
                LatLng e = new LatLng(-35.234919, 149.091661);
                LatLng w = new LatLng(-35.242977, 149.073928);
                int padding = 30;
                LatLngBounds.Builder b = new LatLngBounds.Builder();
                b.include(n);
                b.include(s);
                b.include(e);
                b.include(w);
                LatLngBounds bounds = b.build();
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,padding));
            }
        });
//Map border
            LatLng uc1 = new LatLng(-35.234941, 149.091604);  // Haydon Dr Kaleen ACT 2617
            LatLng uc2 = new LatLng(-35.234758, 149.091448);  // 2
            LatLng uc3 = new LatLng(-35.234671, 149.090684); // 3
            LatLng uc4 = new LatLng(-35.234436, 149.089268);  // 4
            LatLng uc5 = new LatLng(-35.233804, 149.087358);  // 5
            LatLng uc6 = new LatLng(-35.232856, 149.085703);  // 6
            LatLng uc7 = new LatLng(-35.232270, 149.084673);  // 7
            LatLng uc8 = new LatLng(-35.231378, 149.082063);  // 8
            LatLng uc9 = new LatLng(-35.231195, 149.080848); // Aikman - Ginninderra
            LatLng uc10 = new LatLng(-35.231285, 149.080462);  // 2
            LatLng uc11 = new LatLng(-35.231712, 149.080317);  //3
            LatLng uc12 = new LatLng(-35.231712, 149.080317);  //4
            LatLng uc13 = new LatLng(-35.232970, 149.079295);  //5
            LatLng uc14 = new LatLng(-35.233915, 149.078662);  //6
            LatLng uc15 = new LatLng(-35.234371, 149.078413);  //7
            LatLng uc16 = new LatLng(-35.235570, 149.077747);  //8
            LatLng uc17 = new LatLng(-35.236626, 149.077342);  //
            LatLng uc18 = new LatLng(-35.237819, 149.077101);  //
            LatLng uc19 = new LatLng(-35.238231, 149.076887);  //
            LatLng uc20 = new LatLng(-35.239263, 149.076170);  //
            LatLng uc21 = new LatLng(-35.241065, 149.075004);  //Aikman - Eastern Valley way
            LatLng uc22 = new LatLng(-35.242429, 149.077310);  //
            LatLng uc23 = new LatLng(-35.242395, 149.079775);  //
            LatLng uc24 = new LatLng(-35.242376, 149.083206);  //
            LatLng uc25 = new LatLng(-35.242370, 149.085365);  //
            LatLng uc26 = new LatLng(-35.242336, 149.087980);  //
            LatLng uc27 = new LatLng(-35.241960, 149.089983);  // College - Haydon
            LatLng uc28 = new LatLng(-35.241763, 149.090129);  // College - Haydon
            LatLng uc29 = new LatLng(-35.240898, 149.089978);  //
            LatLng uc30 = new LatLng(-35.240229, 149.089981); //
            LatLng uc31 = new LatLng(-35.238426, 149.090394);  // Haydon - Uni
            LatLng uc32 = new LatLng(-35.237500, 149.090789);  // bus
            LatLng uc33 = new LatLng(-35.236806, 149.091030);  // 1
            LatLng uc34 = new LatLng(-35.235594, 149.091473);  // 2
            LatLng uc35 = new LatLng(-35.235111, 149.091650);  //done

            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.geodesic(true);
            polygonOptions.strokeColor(getColor(R.color.common_google_signin_btn_text_light_disabled));
            polygonOptions.fillColor(getColor(R.color.colorBackground));
            polygonOptions.add(uc1, uc2, uc3, uc4, uc5, uc6, uc7, uc8, uc9, uc10,
                    uc11, uc12, uc13, uc14, uc15, uc16, uc17, uc18, uc19,
                    uc20, uc21, uc22, uc23, uc24, uc25, uc26, uc27, uc28, uc29,
                    uc30, uc31, uc32, uc33, uc34, uc35);

            Polygon polygon = mMap.addPolygon(polygonOptions);
            polygon.setClickable(true);

        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {
                Toast.makeText(getApplicationContext(), "University of Canberra",
                        Toast.LENGTH_LONG).show();
                polygon.setStrokeColor(getColor(R.color.common_google_signin_btn_text_light_pressed));
            }

        });
//marker street view
        final LatLng svUc1 = new LatLng(-35.238582, 149.0895637);
        MarkerOptions StV1 = new MarkerOptions()
                .position(svUc1)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.streetview))
                .title("University of Canberra");
        final Marker sv1 = mMap.addMarker(StV1);

        final LatLng svUc2 = new LatLng(-35.233867, 149.087311);
        final Marker sv2 = mMap.addMarker(new MarkerOptions()
                .position(svUc2)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.streetview))
                .title("Canberra Shoulder Physio"));
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Intent intent = new Intent(getApplicationContext(), SvActivity.class);
                startActivity(intent);
            }
        });
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Intent intent = new Intent(getApplicationContext(), StreetViewActivity.class);
                startActivity(intent);
            }
        });
//infoWindow
//*******************UCFIT*************************************************************************
        MarkerOptions ucFit_marker =  new MarkerOptions()
            .position(new LatLng(-35.2381872,149.0842049))
            .draggable(false)
            .title("UC Fit! Sport & Health")
            .snippet("University of Canberra, Building 29")
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.uc_fit))
            .flat(true);
        final Marker ucfit = mMap.addMarker((ucFit_marker));
//**********************THECOFFEEGROUNDS***********************************************************
        MarkerOptions theCoffeeGrounds_marker =  new MarkerOptions()
            .position(new LatLng(-35.239043, 149.0823))
            .draggable(false)
            .title("The Coffee Grounds")
            .snippet("Coffee Shop")
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.the_coffee_grounds))
            .flat(true);
        final Marker coffeegrounds = mMap.addMarker((theCoffeeGrounds_marker));
//*********************NATSEM**********************************************************************
        MarkerOptions NATSEM_marker =  new MarkerOptions()
            .position(new LatLng(-35.238748,149.0859001))
            .draggable(false)
            .title("NATSEM")
            .snippet("Research Institute")
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.natsem))
            .flat(true);
        final Marker natsem = mMap.addMarker((NATSEM_marker));
//********************************Ochre Health Medical Centre *************************************
        MarkerOptions Ochre_marker =  new MarkerOptions()
            .position( new LatLng(-35.2347139,149.085559))
            .draggable(false)
            .title("Ochre Health Medical Centre")
            .snippet("University of Canberra,Building 28")
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ochre))
            .flat(true);
        final Marker ochre = mMap.addMarker((Ochre_marker));
//********************************INSPIRE Centre for ICT Education ********************************
        MarkerOptions inspire_marker =  new MarkerOptions()
            .position(new LatLng(-35.238110, 149.082363))
            .draggable(false)
            .title("INSPIRE Centre for ICT Education")
            .snippet("University of Canberra,Building 25")
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ict))
            .flat(true);
        final Marker inspire = mMap.addMarker((inspire_marker));
//********************************The University of Canberra Library ******************************
        MarkerOptions Library_marker =  new MarkerOptions()
            .position(new LatLng(-35.238017, 149.083404))
            .draggable(false)
            .title("The University of Canberra Library")
            .snippet("University of Canberra,Building 8")
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.library))
            .flat(true);
        final Marker library = mMap.addMarker((Library_marker));
//********************************Retro Cafe ******************************************************
        MarkerOptions Retro_marker =  new MarkerOptions()
            .position(new LatLng(-35.240537, 149.088035))
            .draggable(false)
            .title("Retro Cafe")
            .snippet("University of Canberra,Building 22")
            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.retro))
            .flat(true);
        final Marker retro = mMap.addMarker((Retro_marker));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){
            @Override
            public View getInfoWindow(Marker marker){return null;}
            @Override
            public View getInfoContents(Marker marker){
                View infoWindow = getLayoutInflater().inflate(R.layout.infowindow_with_image, null);
                TextView title = (TextView) infoWindow.findViewById(R.id.title);
                TextView snippet = (TextView) infoWindow.findViewById(R.id.snippet);
                ImageView image = (ImageView) infoWindow.findViewById(R.id.info_image);
                title.setText(marker.getTitle());
                snippet.setText(marker.getSnippet());
                if (marker.getId().equals(ucfit.getId())){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.uc_fit, getTheme()));
                }if (marker.getId().equals(coffeegrounds.getId())){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.the_coffee_grounds, getTheme()));
                }if (marker.getId().equals(natsem.getId())){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.natsem, getTheme()));
                }if (marker.getId().equals(ochre.getId())){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.ochre, getTheme()));
                }if (marker.getId().equals(inspire.getId())){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.ict, getTheme()));
                }if (marker.getId().equals(library.getId())){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.library, getTheme()));
                }if (marker.getId().equals(retro.getId())){
                    image.setImageDrawable(getResources().getDrawable(R.mipmap.retro, getTheme()));
                }
                return infoWindow;
            }
        });
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(getApplicationContext(), "Opening page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                if ( marker.getId().equals(retro.getId())) {
                    intent.putExtra("url", "http://www.retrocafe.net.au/");
                }if ( marker.getId().equals(library.getId())) {
                    intent.putExtra("url", "http://www.canberra.edu.au/library");
                }if ( marker.getId().equals(inspire.getId())) {
                    intent.putExtra("url", "http://www.inspire.edu.au/");
                }if ( marker.getId().equals(ochre.getId())) {
                    intent.putExtra("url", "http://www.ochrehealth.com.au/practices/medical-centre-bruce/");
                }if ( marker.getId().equals(natsem.getId())) {
                    intent.putExtra("url", "http://www.natsem.canberra.edu.au");
                }if ( marker.getId().equals(coffeegrounds.getId())) {
                    intent.putExtra("url", "http://thecoffeegrounds.com.au/");
                }if ( marker.getId().equals(ucfit.getId())) {
                    intent.putExtra("url", "http://www.ucunion.com.au/");
                }
                startActivity(intent);
            }
        });
    }
}