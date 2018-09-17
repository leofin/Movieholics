package com.fin.leo.movieholics.TMDb.entity;

public class Movie {
    private String title;
    private Integer vote_count;
    private Integer id;
    private boolean video;
    private float vote_average;
    private float popularity;
    private String poster_path;
    private String original_language;
    private String original_title;
    private Integer[] genre_ids;
    private String backdrop_path;
    private boolean adult;
    private String overview;
    private String release_date;

    public Movie(String title, Integer vote_count, Integer id, boolean video, float vote_average, float popularity, String poster_path, String original_language, String original_title, Integer[] genre_ids, String backdrop_path, boolean adult, String overview, String release_date){
        super();
        this.title = title;
        this.vote_count = vote_count;
        this.id = id;
        this.video = video;
        this.vote_average = vote_average;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.genre_ids = genre_ids;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.release_date;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public Integer[] getGenre_ids() {
        return genre_ids;
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
}
