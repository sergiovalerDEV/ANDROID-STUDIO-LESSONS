package com.example.themoviedb_001.movies_api;

import com.example.themoviedb_001.json_mapper.Movie;
import com.example.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesAPI {

    @GET("movie/popular?api_key=61e0d26ead78a0b630a6ffe401e15a6a")
    Call<MovieResponse> getPopularMovies();

    @GET("search/movie?api_key=61e0d26ead78a0b630a6ffe401e15a6a")
    Call<MovieResponse> searchMovies(@Query("query") String query);

    @GET("movie/{movie_id}?api_key=61e0d26ead78a0b630a6ffe401e15a6a")
    Call<Movie> getMovieDetails(@Path("movie_id") int movieId);
}
