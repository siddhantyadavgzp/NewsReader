package com.apress.gerber.newsreader;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterFaceAPI {

    @GET("v2/everything")
    Call<News> getNews(@Query("q") String search, @Query("from") String Date, @Query("sortBy") String s, @Query("apiKey") String apiKey);

}

