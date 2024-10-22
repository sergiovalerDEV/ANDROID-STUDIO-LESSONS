package com.example.myapplication.login_user.model;

import com.example.myapplication.beans.User;
import com.example.myapplication.login_user.ContractLoginUser;
import com.example.myapplication.login_user.data.MyData;
import com.example.myapplication.utils.ApiService;
import com.example.myapplication.utils.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements ContractLoginUser.Model {
    private static final String IP_BASE= "http://192.168.1.9:3000/";

    @Override
    public void loginApi(User user, OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient(IP_BASE).create(ApiService.class);

        User loginUser = new User();
        loginUser.setEmail(user.getEmail());
        loginUser.setPassword(user.getPassword());

        Call<MyData> call = apiService.login(loginUser);

        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
               if (response.isSuccessful()){
                   MyData myData = response.body();
                   if (myData !=null && myData.getUser()!=null){
                       onLoginUserListener.onFinished(loginUser);
                   }
               }else {
                   onLoginUserListener.onFailure("No se encontró el usuario en la respuesta");
               }
            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                handleNetWorkError(t, onLoginUserListener);
            }
        });

    }

    private void handleNetWorkError(Throwable t, OnLoginUserListener listener){
        listener.onFailure("Error de login");
    }
}