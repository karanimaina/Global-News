package com.mainafelix.globalnews;

import android.util.Log;

import com.mainafelix.globalnews.models.NewsCollection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsCollection> getArticle(
            @Query("country") String country,
            @Query("category") String category,
            @Query("q")String query,
            @Query("apiKey")String api_key);
    }




