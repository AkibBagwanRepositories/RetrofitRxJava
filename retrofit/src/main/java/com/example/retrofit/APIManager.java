package com.example.retrofit;

import com.example.retrofit.model.JsonResponse;
import com.example.retrofit.model.UserModel;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Bagwan Akib on 12/22/2019.
 */
public class APIManager {
    public static JsonResponse testApi() throws RequestException {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonResponse> responseCall = apiInterface.testGitApi();
        return new Execute().perform(responseCall);
    }

    public static List<UserModel> testApiUser() throws RequestException {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<UserModel>> responseCall = apiInterface.testGitApiUsers();
        return new Execute().performUser(responseCall);
    }
}
