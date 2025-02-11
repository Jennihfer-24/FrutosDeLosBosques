package cl.virginio.gomez.frutos.secos.frutossecosapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.virginio.gomez.frutos.secos.frutossecosapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MAPA", "Inicia mapa");
        super.onCreate(savedInstanceState);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapa1);
        mapFragment.getMapAsync(this);

/*
 LayoutInflater inflater = getLayoutInflater();
        binding = ActivityMapsBinding.inflate(inflater);
        View view = binding.getRoot();
        setContentView(view);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapa1);
        mapFragment.getMapAsync(this);

        EdgeToEdge.enable(this);
        Button buttonVolver = findViewById(R.id.buttonVolver1);


        buttonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "Boton presionado para volver");
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //setContentView(R.layout.activity_maps);
*/
    }


    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng tienda1 = new LatLng(-36.603367, -72.091297);
        LatLng tienda2 = new LatLng(-36.604587, -72.083914);
        LatLng tienda3 = new LatLng(-36.6119628,-72.07268723);
        LatLng tienda4 = new LatLng(-36.602517302817866,-72.10115649861793);



        mMap.addMarker(new MarkerOptions().position(tienda1).title("Frutos 1"));
        mMap.addMarker(new MarkerOptions().position(tienda2).title("Frutos 2"));
        mMap.addMarker(new MarkerOptions().position(tienda3).title("Frutos 3"));
        mMap.addMarker(new MarkerOptions().position(tienda4).title("Frutos 4"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(tienda1));
        mMap.setMinZoomPreference(4.0F);
        mMap.setMaxZoomPreference(18.0f);
    }
}