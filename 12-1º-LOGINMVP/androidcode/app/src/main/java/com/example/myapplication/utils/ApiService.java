package com.example.myapplication.utils;

import com.example.myapplication.beans.User;
import com.example.myapplication.login_user.data.MyData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/login")
    Call<MyData> login(@Body User user);
}
