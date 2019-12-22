package com.example.retrofitrxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.APIManager;
import com.example.retrofit.RequestException;
import com.example.retrofit.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements CallBackInterface {

    CompositeDisposable mDisposable = new CompositeDisposable();
    RecyclerView rvUsers;
    GitUserAdapter adapter;
    List<UserModel> userModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
        mDisposable.add(createThread(this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    Log.i("onComplete", userModels.size() + "");
                    rvUsers.setAdapter(adapter);
                    adapter = new GitUserAdapter(this, (ArrayList<UserModel>) userModels);
                    rvUsers.setAdapter(adapter);
                }));

    }

    private void init() {
        userModels = new ArrayList<>();
        rvUsers = findViewById(R.id.rv_main);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
    }


    public void callApi(CallBackInterface callBackInterface) {
        try {
            ArrayList<UserModel> users = (ArrayList<UserModel>) APIManager.testApiUser();
            for (UserModel user : users) {
                Log.d("User", user.getGistsUrl());
            }
            callBackInterface.reload(users);
        } catch (RequestException e) {
            e.printStackTrace();
            Log.i("ERROR_API_CALL", "server");
        }
    }

    public Completable createThread(final CallBackInterface callBackInterface) {
        return Completable.fromAction(() -> callApi(callBackInterface));
    }

    @Override
    public void reload(List<UserModel> users) {
        userModels.clear();
        Log.i("onResponse", users.size() + "");
        userModels.addAll(users);
    }
}
