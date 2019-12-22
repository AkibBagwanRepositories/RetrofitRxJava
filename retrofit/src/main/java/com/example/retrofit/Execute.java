package com.example.retrofit;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.model.JsonResponse;
import com.example.retrofit.model.UserModel;

import java.lang.annotation.Annotation;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Bagwan Akib on 12/21/2019.
 */
public class Execute {

    public JsonResponse perform(Call<JsonResponse> call) throws RequestException {
        JsonResponse jsonResponse = null;
//        try {/
        Response<JsonResponse> response;
        try {
            response = call.execute();
        } catch (Exception e) {
            if (e.getMessage() != null)
                Log.i("Exception", e.getMessage());
            throw new RequestException(APIConsts.SERVER_NOT_RESPONDING);
        }
        if (response != null && !response.isSuccessful() && response.errorBody() != null) {
            JsonResponse error;
            try {
                Converter<ResponseBody, JsonResponse> errorConverter =
                        ApiClient.getClient().responseBodyConverter(JsonResponse.class, new Annotation[0]);
                error = errorConverter.convert(response.errorBody());
            } catch (Exception e) {
                throw new RequestException(APIConsts.ERROR_WHILE_CONNECTING_TO_SERVER);
            }
            if (error != null) {
                if (error.getAuth() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(APIConsts.AUTH, error.getAuth());
                    throw new RequestException(error.getStatus(), error.getId(), bundle);
                }
                throw new RequestException(error.getStatus());
            }
        }
        if (response != null) {
            jsonResponse = response.body();
            if (!jsonResponse.getStatus().equalsIgnoreCase(APIConsts.SUCCESS))
                throw new RequestException(jsonResponse.getStatus());
        }
        return jsonResponse;
    }

    public List<UserModel> performUser(Call<List<UserModel>> call) throws RequestException {
        List<UserModel> jsonResponse = null;
//        try {/
        Response<List<UserModel>> response;
        try {
            response = call.execute();
        } catch (Exception e) {
            if (e.getMessage() != null)
                Log.i("Exception", e.getMessage());
            throw new RequestException(APIConsts.SERVER_NOT_RESPONDING);
        }
        if (response != null && !response.isSuccessful() && response.errorBody() != null) {
            JsonResponse error;
            try {
                Converter<ResponseBody, JsonResponse> errorConverter =
                        ApiClient.getClient().responseBodyConverter(JsonResponse.class, new Annotation[0]);
                error = errorConverter.convert(response.errorBody());
            } catch (Exception e) {
                throw new RequestException(APIConsts.ERROR_WHILE_CONNECTING_TO_SERVER);
            }
            if (error != null) {
                if (error.getAuth() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(APIConsts.AUTH, error.getAuth());
                    throw new RequestException(error.getStatus(), error.getId(), bundle);
                }
                throw new RequestException(error.getStatus());
            }
        }
        if (response != null) {
            jsonResponse = response.body();
        }
        return jsonResponse;
    }
}
