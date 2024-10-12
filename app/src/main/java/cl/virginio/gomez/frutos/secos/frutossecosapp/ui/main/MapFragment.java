package cl.virginio.gomez.frutos.secos.frutossecosapp.ui.main;

import androidx.activity.EdgeToEdge;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.virginio.gomez.frutos.secos.frutossecosapp.MainActivity;
import cl.virginio.gomez.frutos.secos.frutossecosapp.MapsActivity;
import cl.virginio.gomez.frutos.secos.frutossecosapp.R;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private MainViewModel mViewModel;
    private GoogleMap mMap;

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
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