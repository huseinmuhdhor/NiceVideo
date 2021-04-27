package com.dev.nicemovie.presenter;

import android.util.Log;

import com.dev.nicemovie.data.model.SearchData;
import com.dev.nicemovie.data.model.SearchResponse;
import com.dev.nicemovie.data.remote.Api;
import com.dev.nicemovie.data.remote.RetrofitFactory;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private static final String TAG = "MainPresenter";
    private View view;

    public MainPresenter(View view) {
        this.view = view;
    }

    public void showMovie(String query) {
        String searchQuery = !query.isEmpty() ? query : "avenger";
        Api.Creator.getInstance()
                .getMovies(RetrofitFactory.API_KEY, searchQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(jsonObject -> {
                    SearchResponse response = new Gson().fromJson(jsonObject, SearchResponse.class);

                    view.showMovies(response.getSearchData());
                }, throwable -> {
                    Log.e(TAG, "showMovie: " + throwable.getMessage());
                });
    }

    public interface View {
        void showMovies(List<SearchData> searchData);
    }
}
