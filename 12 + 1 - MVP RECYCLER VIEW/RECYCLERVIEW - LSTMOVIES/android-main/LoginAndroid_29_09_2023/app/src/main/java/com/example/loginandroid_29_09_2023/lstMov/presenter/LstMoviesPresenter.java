package com.example.loginandroid_29_09_2023.lstMov.presenter;

import android.util.Log;
import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.lstMov.ContractListMovies;
import com.example.loginandroid_29_09_2023.lstMov.model.LstMoviesModel;

import java.util.ArrayList;

public class LstMoviesPresenter implements ContractListMovies.Presenter,
        ContractListMovies.Model.OnLstMoviesListener {

    private ContractListMovies.View vista;
    private LstMoviesModel lstMoviesModel;

    public LstMoviesPresenter(ContractListMovies.View vista) {
        this.vista = vista;
        lstMoviesModel = new LstMoviesModel(this);
    }

    @Override
    public void lstMovies(String filtro) {
        lstMoviesModel.moviesAPI("", this);
    }

    @Override
    public void onFinished(ArrayList<Pelicula> lstPelicula) {
        // Agregamos el log aquí para verificar los datos cargados
        for (Pelicula p : lstPelicula) {
            Log.d("PeliculaDebug", "Título: " + p.getTitulo() + ", URL Imagen: " + p.getUrlimagen());
        }

        // Luego, actualiza la vista con la lista
        vista.successMovies(lstPelicula);
    }

    @Override
    public void onFailure(String err) {
        // Aquí puedes manejar el error si lo deseas
        Log.e("PeliculaError", "Error al cargar películas: " + err);
    }
}
