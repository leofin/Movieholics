package com.fin.leo.movieholics.TMDb.entity;

import java.util.HashMap;

public class Upcoming {

    private Movie[] results;
    private HashMap<String, String> dates;
    private Integer total_pages;
    private Integer total_results;

    public Upcoming(){
        super();
    }

    public Movie[] getMovies() {
        return results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

}
