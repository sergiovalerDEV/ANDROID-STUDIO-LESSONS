package com.example.a004singleton.services;

import android.content.Intent;
import android.widget.Toast;

import com.example.a004singleton.MainActivity;
import com.example.a004singleton.MainActivity2;

public class ServicePantallaPrincipal {

    /*public ServicePantallaPrincipal(MainActivity padre){
        this.padre = padre;
    }*/
    public void saludar(){
        Toast.makeText( MainActivity.getInstance(),
                "Saludar Android!",
                Toast.LENGTH_SHORT).show();
        // INTENT
            // 2 LÍNEAS DE CÓDIGO
                                             // ORIGEN - DESTINO
    Intent navegarEntrePantallas = new Intent(MainActivity.getInstance(),
                            MainActivity2.class);
        MainActivity.getInstance().startActivity(navegarEntrePantallas);
    }
    public void altaUsuario(){
        Toast.makeText(MainActivity2.getInstance(),
                        "Hola 2ª pantalla",
                            Toast.LENGTH_SHORT).show();
    }

}
