package com.example.mohamed.quizretrofit.view;

import com.example.mohamed.quizretrofit.model.Movie;

import java.util.List;

/**
 * Created by mohamed on 17/09/2017.
 */

public interface MainView {
    void showProgress();
    void hideProgress();
    void showMovieClickedMessage(Movie s);
    void showMovies(List<Movie> movies);
    void showConnectionError();
}
