package com.example.mohamed.quizretrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohamed on 17/09/2017.
 */

public class Movie {
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String posterPath;

    public Movie(String title, String posterPath) {
        this.title = title;

        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }


    public String getPosterPath() {
        return posterPath;
    }



}
