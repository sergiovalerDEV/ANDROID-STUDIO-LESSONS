package com.example.a09;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MoviesRepository moviesRepository;
    private static final String API_KEY = "92cf77a9e26205964632fc35feb9b925"; // Reemplaza con tu clave de API
    private static final String LANGUAGE = "es-ES"; // Idioma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesRepository = new MoviesRepository();

        Button buttonPopularMovies = findViewById(R.id.button_popular_movies);
        Button buttonSearchMovies = findViewById(R.id.button_search_movies);
        Button buttonMovieDetails = findViewById(R.id.button_movie_details);

        buttonPopularMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPopularMovies();
            }
        });

        buttonSearchMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchMovies("titanic"); // Cambia "titanic" por la búsqueda que desees
            }
        });

        buttonMovieDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMovieDetails(550); // Cambia 550 por el ID de la película que desees
            }
        });
    }

    private void getPopularMovies() {
        moviesRepository.getPopularMovies(API_KEY, LANGUAGE, 1, new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    // Procesa y muestra las películas
                    Toast.makeText(MainActivity.this, "Películas populares obtenidas: " + movies.size(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // Manejar el error
                Toast.makeText(MainActivity.this, "Error al obtener películas populares", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void searchMovies(String query) {
        moviesRepository.searchMovies(API_KEY, LANGUAGE, query, 1, new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> movies = response.body().getResults();
                    // Procesa y muestra las películas encontradas
                    Toast.makeText(MainActivity.this, "Resultados de búsqueda: " + movies.size(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // Manejar el error
                Toast.makeText(MainActivity.this, "Error al buscar películas", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMovieDetails(int movieId) {
        moviesRepository.getMovieDetails(movieId, API_KEY, LANGUAGE, new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Movie movie = response.body();
                    // Muestra los detalles de la película
                    Toast.makeText(MainActivity.this, "Título: " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                // Manejar el error
                Toast.makeText(MainActivity.this, "Error al obtener detalles de la película", Toast.LENGTH_SHORT).show();
            }
        });
    }
}