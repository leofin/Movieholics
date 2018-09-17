package com.fin.leo.movieholics.TMDb.services;

import com.fin.leo.movieholics.TMDb.entity.Genre;
import com.fin.leo.movieholics.TMDb.entity.Genres;
import com.fin.leo.movieholics.TMDb.entity.Upcoming;
import com.fin.leo.movieholics.utils.MyHTTPRequest;
import com.google.gson.Gson;

public class API {
    private static String api_key = "1f54bd990f1cdfb230adb312546d765d";
    private static Gson gson = new Gson();

    public static Upcoming getUpcomingMovies(Integer page){
        if(page == null || page < 1){
            page = 1;
        }
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + api_key + "&page="+ page;
        String jsonResponse = MyHTTPRequest.getRequest(url);
        Upcoming upcoming = gson.fromJson(jsonResponse, Upcoming.class);

        return upcoming;
    }

    public static Genre[] getGenres(){
        String url = "https://api.themoviedb.org/3/genre/movie/list?api_key=" + api_key;
        String jsonResponse = MyHTTPRequest.getRequest(url);
        Genres genres = gson.fromJson(jsonResponse, Genres.class);
        return genres.getGenres();
    }

    public static String getUrlRepositoryBackdrop(){
        String url = "https://image.tmdb.org/t/p/w185_and_h278_bestv2/";
        return url;
    }

    public static String getUrlRepositoryPoster(){
        String url ="https://image.tmdb.org/t/p/w220_and_h330_bestv2/";
        return url;
    }
}