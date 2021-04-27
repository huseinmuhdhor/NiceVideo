package com.dev.nicemovie.data.remote;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET(".")
    Observable<JsonObject> getMovies(@Query("apikey") String apiKey,
                                     @Query("s") String s);

    @GET(".")
    Observable<JsonObject> getDetailMovie(@Query("apikey") String apiKey,
                                          @Query("i") String imdbId);

    class Creator {
        private static Api INSTANCE;

        public static Api getInstance() {
            if (INSTANCE == null) {
                INSTANCE = RetrofitFactory.newInstance().create(Api.class);
            }
            return INSTANCE;
        }
    }
}
