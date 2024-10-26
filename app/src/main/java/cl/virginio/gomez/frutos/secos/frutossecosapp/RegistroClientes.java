package cl.virginio.gomez.frutos.secos.frutossecosapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import cl.virginio.gomez.frutos.secos.frutossecosapp.dto.ClienteDto;

public class RegistroClientes extends AppCompatActivity {

    private FirebaseFirestore mfirestore;
    private FirebaseAuth mAuth;

    private EditText nombres;
    private EditText apellidoPat;
    private EditText apellidoMat;
    private EditText direccion;
    private EditText ciudad;
    private EditText telefono;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_clientes);
        nombres = findViewById(R.id.editNombres);
        apellidoPat = findViewById(R.id.editApPaterno);
        apellidoMat = findViewById(R.id.editApMaterno);
        direccion = findViewById(R.id.editDireccion);
        ciudad = findViewById(R.id.editCiudad);
        telefono = findViewById(R.id.editTelefono);
        email = findViewById(R.id.editMail);
        mfirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Button buttonRegistrar = findViewById(R.id.buttonRegistrarCli);

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "Boton presionado para Registrar Cliente");
                String nombresStr = nombres.getText().toString().trim();
                String apellidoPatStr = apellidoPat.getText().toString().trim();
                String apellidoMatStr = apellidoMat.getText().toString().trim();
                String direccionStr = direccion.getText().toString().trim();
                String ciudadStr = ciudad.getText().toString().trim();
                String telefonoStr = telefono.getText().toString().trim();
                String emailStr = email.getText().toString().trim();
                ClienteDto cliente = new ClienteDto(nombresStr, apellidoPatStr, apellidoMatStr,
                        direccionStr, ciudadStr, telefonoStr, emailStr);

                if (clienteValido(cliente)) {
                    postCliente(cliente);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Ingrese los datos faltantes",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean clienteValido(ClienteDto cliente) {
        if (cliente.getNombres().isEmpty() || cliente.getApellidoPat().isEmpty()
                || cliente.getApellidoMat().isEmpty() || cliente.getEmail().isEmpty()
                || cliente.getTelefono().isEmpty()) {
            return false;
        }
        return true;
    }

    private void postCliente(ClienteDto clienteDto) {
        //String idUser = mAuth.getCurrentUser().getUid();
        DocumentReference id = mfirestore.collection("cliente").document();

        Map<String, Object> map = new HashMap<>();
        //map.put("id_user", idUser);
        map.put("id", id.getId());
        map.put("nombres", clienteDto.getNombres());
        map.put("apellido_paterno", clienteDto.getApellidoPat());
        map.put("apellido_materno", clienteDto.getApellidoMat());
        map.put("direccion", clienteDto.getDireccion());

        mfirestore.collection("cliente").document(id.getId()).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR {} {}",e.getMessage(), e);
                Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }


}