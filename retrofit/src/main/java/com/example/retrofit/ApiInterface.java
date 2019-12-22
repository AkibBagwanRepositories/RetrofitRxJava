package com.example.retrofit;

import com.example.retrofit.model.JsonResponse;
import com.example.retrofit.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Bagwan Akib on 12/21/2019.
 */
public interface ApiInterface {
    @Headers("HeaderOne: somedata")
    @GET("/path/{value}")
    Call<JsonResponse> testApi(@Path("value") String value);

    @GET("/repos/vmg/redcarpet/issues")
    Call<JsonResponse> testGitApi();

    @GET("/users")
    Call<List<UserModel>> testGitApiUsers();
}
