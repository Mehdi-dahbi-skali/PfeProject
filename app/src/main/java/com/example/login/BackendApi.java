package com.example.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BackendApi {

    @FormUrlEncoded
    @POST("/api/users")
    Call<User> checkUser(@Field("name") String name, @Field("job") String job);

}
