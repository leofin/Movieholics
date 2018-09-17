package com.fin.leo.movieholics.app.models;

import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable {
    private String title;
    private Integer id;
    private String poster_path;
    private String[] genres;
    private String overview;
    private String release_date;

    public Movie(String title, Integer id, String poster_path, String[] genres, String overview, String release_date){
        super();
        this.title = title;
        this.id = id;
        this.poster_path = poster_path;
        this.genres = genres;
        this.overview = overview;
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.release_date + " - " + Arrays.toString(this.getGenres());
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Integer getId() {
        return id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String[] getGenres() {
        return genres;
    }
}
