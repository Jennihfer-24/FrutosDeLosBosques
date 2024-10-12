package cl.virginio.gomez.frutos.secos.frutossecosapp;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import cl.virginio.gomez.frutos.secos.frutossecosapp.databinding.FragmentMainBinding;
import cl.virginio.gomez.frutos.secos.frutossecosapp.ui.main.MapFragment;

public class MapActivity extends AppCompatActivity {
    private FragmentMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MapFragment.newInstance())
                    .commitNow();
        }
/*
        LayoutInflater inflater = getLayoutInflater();
        binding = FragmentMainBinding.inflate(inflater);
        View view = binding.getRoot();
        setContentView(view);

        EdgeToEdge.enable(this);
        Button buttonVolver = findViewById(R.id.buttonVolver2);


        buttonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "Boton presionado para volver");
                Intent intent = new Intent(MapActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}