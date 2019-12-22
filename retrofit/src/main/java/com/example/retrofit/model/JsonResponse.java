package com.example.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bagwan Akib on 12/21/2019.
 */
public class JsonResponse implements Serializable {
    @SerializedName("auth")
    private String auth;
    private String name;
    private String status;
    private int id;

    public JsonResponse() {
    }

    public JsonResponse(String status, String auth, String name, int id) {
        this.auth = auth;
        this.name = name;
        this.status = status;
        this.id = id;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
