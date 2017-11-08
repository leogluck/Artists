package com.example.leo.artists.model;

import com.example.leo.artists.model.responses.ArtistResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Leo on 08.11.2017
 */

public class ApiService {
    private static final String BASE_URL = "http://ws.audioscrobbler.com/";
    private static final String METHOD = "geo.gettopartists";
    private static final String API_KEY ="e81f61890b7ff8633ca024d0faa449e7";
    private static final String FORMAT ="json";
    private ApiInterface mApiInterface;
    private static ApiService instance;

    private ApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApiInterface = retrofit.create(ApiInterface.class);
    }

    public static ApiService getInstance() {
        return instance = new ApiService();
    }

    public Observable<ArtistResponse> getArtists (String country) {
        return mApiInterface.getArtists(METHOD, country, API_KEY, FORMAT);
    }

    interface ApiInterface {

        @GET("2.0/")
        Observable<ArtistResponse> getArtists (@Query("method") String method, @Query("country") String country,
                                           @Query("api_key") String apiKey, @Query("format") String format);

    }
}
