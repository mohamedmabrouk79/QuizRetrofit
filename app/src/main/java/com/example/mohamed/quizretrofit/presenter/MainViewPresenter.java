package com.example.mohamed.quizretrofit.presenter;

import com.example.mohamed.quizretrofit.api.Requests;
import com.example.mohamed.quizretrofit.api.requestsInterface;
import com.example.mohamed.quizretrofit.model.Movie;
import com.example.mohamed.quizretrofit.view.MainView;

import java.util.List;

/**
 * Created by mohamed on 17/09/2017.
 */

public class MainViewPresenter extends BasePresenter implements MainPresenter {
    private MainView mainView;
    private Requests mRequests;
    public static final String AI_KEY="c258ef3167d2f4ec83da643c7f76b785";

    public MainViewPresenter(MainView mainView,Requests mRequests){
        this.mainView=mainView;
        this.mRequests=mRequests;
    }

    @Override
    public void loadMovieData() {
      mainView.showProgress();
        mRequests.startRequest(AI_KEY, new requestsInterface() {
            @Override
            public void onSucess(List<Movie> movies) {
                mainView.hideProgress();
                mainView.showMovies(movies);
            }

            @Override
            public void onFaile(String f) {
            mainView.showConnectionError();
                mainView.hideProgress();
            }
        });
    }

    @Override
    public void clickMovieItem(Movie item) {
            mainView.showMovieClickedMessage(item);
    }
}
