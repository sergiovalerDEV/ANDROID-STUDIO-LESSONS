package com.example.loginandroid_29_09_2023.lstMov.data;

import com.example.loginandroid_29_09_2023.beans.Pelicula;

import java.util.List;

public class DataMovies {
    private List<Pelicula> lstMovies; // Cambiado de lstPeliculas a lstMovies
    private String message; // Mensaje adicional

    // Getters
    public List<Pelicula> getLstMovies() {
        return lstMovies; // Cambiado de getLstPeliculas a getLstMovies
    }

    public String getMessage() {
        return message;
    }

    // Puedes añadir más métodos según sea necesario
}
