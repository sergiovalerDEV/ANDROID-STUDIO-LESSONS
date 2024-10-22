package com.example.wallapop.utils;



import com.example.wallapop.beans.User;
import com.example.wallapop.login_user.data.MyData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    //Login
    @POST("/login")
    Call<MyData> login(@Body User user);

    //Registro
    @POST("/register")
    Call<MyData> register(@Body User user);
}
