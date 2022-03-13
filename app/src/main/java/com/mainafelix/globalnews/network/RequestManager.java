package com.mainafelix.globalnews.network;

import static com.mainafelix.globalnews.Constants.NEWS_API_KEY;

import android.content.Context;
import android.widget.Toast;

import com.mainafelix.globalnews.models.OnFetchDataListener;
import com.mainafelix.globalnews.models.NewsCollection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")// calls the base url
            .addConverterFactory(GsonConverterFactory.create())// serialization
            .build();

    public void  getNewsHeadlines(OnFetchDataListener listener, String category, String query,String country){

        CallNewsApi  callNewsApi = retrofit.create(CallNewsApi.class);// creating a request using retrofit
        Call<NewsCollection>call = callNewsApi.callHeadlines(country,category,query,NEWS_API_KEY);//fetching data from the api
        try{
            call.enqueue(new Callback<NewsCollection>() {//makes the asynchronous request
                @Override
                public void onResponse(Call<NewsCollection> call, Response<NewsCollection> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(context, "Success!!!", Toast.LENGTH_SHORT).show();
                    }
                    listener.OnFetchData(response.body().getArticles(),response.message());
                }

                @Override
                public void onFailure(Call<NewsCollection> call, Throwable t) {
                    listener.OnError("Request failed");
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public RequestManager(Context context) {
        this.context = context;
    }
    public interface CallNewsApi{
        @GET("top-headlines")// declaring the endpoint
        Call<NewsCollection> callHeadlines(
                @Query("country") String country,// pass in the required parameters
                @Query("category") String category,//
                @Query("q")String query,
                @Query("apiKey")String api_key);
    }
}

