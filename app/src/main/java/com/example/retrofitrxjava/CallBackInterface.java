package com.example.retrofitrxjava;

import com.example.retrofit.model.UserModel;

import java.util.List;

/**
 * Created by Bagwan Akib on 12/22/2019.
 */
public interface CallBackInterface {
    void reload(List<UserModel> users);
}
