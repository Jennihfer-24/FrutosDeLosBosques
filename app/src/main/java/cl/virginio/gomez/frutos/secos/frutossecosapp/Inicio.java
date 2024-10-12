package cl.virginio.gomez.frutos.secos.frutossecosapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Inicio extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        Button buttonMap = findViewById(R.id.buttonmap);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "Boton presionado para mapa");
                Intent intent = new Intent(Inicio.this, MapActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}