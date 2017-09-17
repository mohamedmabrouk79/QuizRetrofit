package com.example.mohamed.quizretrofit.ui;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mohamed.quizretrofit.R;
import com.example.mohamed.quizretrofit.adapter.MoviesAdapter;
import com.example.mohamed.quizretrofit.api.Requests;
import com.example.mohamed.quizretrofit.model.Movie;
import com.example.mohamed.quizretrofit.presenter.MainViewPresenter;
import com.example.mohamed.quizretrofit.view.MainView;

import java.util.List;

public class MainActivity extends BaseActivity implements MainView,MoviesAdapter.MovieItemListener {
   private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MainViewPresenter mainViewPresenter;
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewPresenter=new MainViewPresenter(this,new Requests());

        initRecyclerView();
        initSwipeRefreshLayout();

    }

    void initRecyclerView(){
     moviesAdapter=new MoviesAdapter(R.layout.movie_item,this,this);
        mRecyclerView= (RecyclerView) findViewById(R.id.movies_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setAdapter(moviesAdapter);
    }

    void initSwipeRefreshLayout(){
      mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.srl);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            mainViewPresenter.loadMovieData();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        mainViewPresenter.loadMovieData();
    }

    @Override
    public void showProgress() {
  if (!mSwipeRefreshLayout.isRefreshing()){
      mSwipeRefreshLayout.post(new Runnable() {
          @Override
          public void run() {
           mSwipeRefreshLayout.setRefreshing(true);
          }
      });
  }
    }

    @Override
    public void hideProgress() {
       if (mSwipeRefreshLayout.isRefreshing()){
           mSwipeRefreshLayout.setRefreshing(false);
       }
    }

    @Override
    public void showMovieClickedMessage(Movie movie) {
        Toast.makeText(this,movie.getTitle()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMovies(List<Movie> movies) {
  moviesAdapter.replaceData(movies);
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(this, "Error at Connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMovieItemClick(Movie item) {
      mainViewPresenter.clickMovieItem(item);
    }
}
