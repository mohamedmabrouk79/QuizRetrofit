package com.example.mohamed.quizretrofit.api;


import com.example.mohamed.quizretrofit.model.Movie;

import java.util.List;

/**
 * Created by mohamed on 17/09/2017.
 */

public interface requestsInterface {
    void onSucess(List<Movie> movies);
    void onFaile(String f);

}
