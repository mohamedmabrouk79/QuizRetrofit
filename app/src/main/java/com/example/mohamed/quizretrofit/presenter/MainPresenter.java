package com.example.mohamed.quizretrofit.presenter;

import com.example.mohamed.quizretrofit.model.Movie;

/**
 * Created by mohamed on 17/09/2017.
 */

public interface MainPresenter {
    void loadMovieData();
    void clickMovieItem(Movie item);
}
