package com.example.ejercicio_parte_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejercicio_parte_2.beans.Usuario;
import com.example.ejercicio_parte_2.datos.SeasData;

public class MainActivity extends AppCompatActivity {
    private EditText edtUser;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = (EditText) findViewById(R.id.edtUsuario);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegarEntrePantallas = new Intent(getBaseContext(), MainActivity2.class);

                Usuario miUsuario = new Usuario();
                miUsuario.setEmail(edtUser.getText().toString());

                SeasData.setUsuario(miUsuario);
                startActivity(navegarEntrePantallas);
            }
        });
    }
}