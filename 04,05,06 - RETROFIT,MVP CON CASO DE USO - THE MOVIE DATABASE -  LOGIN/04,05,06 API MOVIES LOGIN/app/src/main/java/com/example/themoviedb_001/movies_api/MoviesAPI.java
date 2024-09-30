package com.example.themoviedb_001.movies_api;

import com.example.themoviedb_001.json_mapper.MovieResponse;

import retrofit2.Call;//Se tiene que llamar Retrofit
import retrofit2.http.GET;

public interface MoviesAPI {

    //Routers!!! express.js  (url base y luego los últimos parámetros del endopint hacia los datos y el tipo de comunicación)
    @GET("movie/popular?api_key=61e0d26ead78a0b630a6ffe401e15a6a")
    Call<MovieResponse> getPopularMovies();
}