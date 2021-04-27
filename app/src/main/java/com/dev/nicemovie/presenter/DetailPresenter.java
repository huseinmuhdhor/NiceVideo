package com.dev.nicemovie.presenter;

import android.util.Log;

import com.dev.nicemovie.data.model.Movie;
import com.dev.nicemovie.data.remote.Api;
import com.dev.nicemovie.data.remote.RetrofitFactory;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenter {

    private static final String TAG = "DetailPresenter";
    private View view;

    public DetailPresenter(View view) {
        this.view = view;
    }

    public void showDetail(String imdbId) {
        Api.Creator.getInstance()
                .getDetailMovie(RetrofitFactory.API_KEY, imdbId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(jsonObject -> {
                    Movie response = new Gson().fromJson(jsonObject, Movie.class);

                    view.showDetail(response);
                }, throwable -> {
                    Log.e(TAG, "showDetail: " + throwable.getMessage());
                });
    }

    public interface View {
        void showDetail(Movie movie);
    }
}
