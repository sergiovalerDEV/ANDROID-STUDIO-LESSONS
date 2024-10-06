package com.example.themoviedb_001;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themoviedb_001.json_mapper.Movie;
import com.example.themoviedb_001.json_mapper.MovieResponse;
import com.example.themoviedb_001.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnGetPopularMovies, btnSearchMovie, btnGetMovieDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetPopularMovies = findViewById(R.id.btnGetPopularMovies);
        btnSearchMovie = findViewById(R.id.btnSearchMovie);
        btnGetMovieDetails = findViewById(R.id.btnGetMovieDetails);

        // Listener para obtener películas populares
        btnGetPopularMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPopularMovies();
            }
        });

        // Listener para buscar una película
        btnSearchMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchMovie("Titanic");
            }
        });

        // Listener para obtener detalles de una película específica
        btnGetMovieDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMovieDetails(550); // Ejemplo con Fight Club
            }
        });
    }

    // Método para obtener las películas populares
    private void getPopularMovies() {
        Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie movie : movies) {
                        Toast.makeText(MainActivity.this, "Popular: " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error fetching popular movies", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para buscar una película por nombre
    private void searchMovie(String query) {
        Call<MovieResponse> call = RetrofitClient.getInstance().searchMovies(query);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    for (Movie movie : movies) {
                        Toast.makeText(MainActivity.this, "Found: " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error searching movies", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método para obtener detalles de una película por ID
    private void getMovieDetails(int movieId) {
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(movieId);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    Toast.makeText(MainActivity.this, "Details: " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error fetching movie details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
