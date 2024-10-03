package com.example.ejercicio_parte_2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejercicio_parte_2.beans.Usuario;
import com.example.ejercicio_parte_2.datos.SeasData;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtUser = (TextView) findViewById(R.id.textView2);
        txtUser.setText(SeasData.getUsuario().getEmail());

    }
}