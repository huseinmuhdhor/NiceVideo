package com.dev.nicemovie.data.remote;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    public static final String BASE_URL = "http://www.omdbapi.com/";
    public static final String BASE_IMAGE_URL = "http://img.omdbapi.com/";
    public static final String API_KEY = "de2a303f";
    private static OkHttpClient okHttpClient;

    public static Retrofit newInstance() {
        RxJava2CallAdapterFactory javaCallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        okHttpClient = builder.build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(javaCallAdapterFactory)
                .build();
    }
}
