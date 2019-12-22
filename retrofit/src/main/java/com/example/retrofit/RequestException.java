package com.example.retrofit;

import android.os.Bundle;

import java.io.IOException;

/**
 * Created by Bagwan Akib on 12/21/2019.
 */
public class RequestException extends IOException {
    String message;

    public RequestException() {
    }

    public RequestException(String message) {
        this.message = message;
    }

    public RequestException(String name, int id, Bundle bundle) {
        this.message = name;
    }
}
