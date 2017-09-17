package com.example.mohamed.quizretrofit.api;


import com.example.mohamed.quizretrofit.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohamed on 17/09/2017.
 */

public class Requests {
    static ApiInterface apiInterface;
    public  void startRequest(String apikey,final requestsInterface requestsInterface){
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<MoviesResponse> call=apiInterface.getTopRatedMovies(apikey);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
              requestsInterface.onSucess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
               requestsInterface.onFaile(t.getMessage());
            }
        });
    }


}
