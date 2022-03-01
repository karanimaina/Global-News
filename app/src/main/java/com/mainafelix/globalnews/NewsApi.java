package com.mainafelix.globalnews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsApi {
    @GET
    Call<News> getAllNews(String country, @Url String url);

    @GET
    Call<News>getNewsByCategory(@Url String Categoryurl);


}
