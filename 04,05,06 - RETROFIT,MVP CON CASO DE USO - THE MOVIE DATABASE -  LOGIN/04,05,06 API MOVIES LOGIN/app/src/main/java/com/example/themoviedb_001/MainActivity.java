package com.example.themoviedb_001;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.themoviedb_001.json_mapper.Movie;
import com.example.themoviedb_001.json_mapper.MovieResponse;
import com.example.themoviedb_001.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<MovieResponse> call = RetrofitClient.getInstance().
                getPopularMovies();  //Instancia del retrofit, llama a popular movies y se trae los datos
                                    //Los devuelve ordenados de forma automática el retrofit y en array en Java

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                //Procesa y muestra las películas aquí
                List<Movie> movies = response.body().getResults();
                for (Movie myMovie: movies
                     ) {
                    Toast.makeText(MainActivity.this,
                            "Movie" + myMovie.getTitle(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }
}