package com.example.a09;

import retrofit2.Call;
import retrofit2.Callback;


public class MoviesRepository {
    private final MoviesService moviesService;

    public MoviesRepository() {
        this.moviesService = RetrofitClient.getInstance().create(MoviesService.class);
    }

    public void getPopularMovies(String apiKey, String language, int page, Callback<MovieResponse> callback) {
        Call<MovieResponse> call = moviesService.getPopularMovies(apiKey, language, page);
        call.enqueue(callback);
    }

    public void searchMovies(String apiKey, String language, String query, int page, Callback<MovieResponse> callback) {
        Call<MovieResponse> call = moviesService.searchMovies(apiKey, language, query, page);
        call.enqueue(callback);
    }

    public void getMovieDetails(int movieId, String apiKey, String language, Callback<Movie> callback) {
        Call<Movie> call = moviesService.getMovieDetails(movieId, apiKey, language);
        call.enqueue(callback);
    }
}
