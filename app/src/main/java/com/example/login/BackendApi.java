package com.example.login;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BackendApi {

    @POST("/api/auth/login")
    Call<User> checkUser(@Body JsonObject body);

    @POST("/api/auth/register")
    Call<User> CreateUser(@Body JsonObject body);

    @GET("/api/posts/")
    Call<List<Post>> GetPostes();

}
