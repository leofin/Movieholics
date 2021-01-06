package com.fin.leo.movieholics.app.services;

import com.fin.leo.movieholics.TMDb.entity.Genre;
import com.fin.leo.movieholics.TMDb.entity.Upcoming;
import com.fin.leo.movieholics.TMDb.services.API;
import com.fin.leo.movieholics.app.models.Movie;

import java.util.ArrayList;
import java.util.HashMap;

public class UpcomingServices {
    private Upcoming upcoming;
    private HashMap<Integer, String> mapGenres;
    private Integer currentPage = 1;
    private static UpcomingServices instanceUpcomingServices;

    public static UpcomingServices getInstanceUpcomingServices(){
        if(instanceUpcomingServices == null){
            instanceUpcomingServices = new UpcomingServices();
        }
        return instanceUpcomingServices;
    }

    public ArrayList<Movie> getUpcomingMovies(Integer page){
        upcoming = fetchUpcomingMoviesTMDb(page);
        if(upcoming == null){
            return new ArrayList<Movie>();
        }else{
            return convertTMDbMoviesToMovies(upcoming.getMovies());
        }
    }

    public Integer getTotalPages(){
        upcoming = fetchUpcomingMoviesTMDb(currentPage);
        if(upcoming == null){
            return 0;
        }else {
            return upcoming.getTotal_pages();
        }
    }

    private Upcoming fetchUpcomingMoviesTMDb(Integer page){
        if(upcoming == null || currentPage != page) {
            currentPage = page;
            upcoming = API.getUpcomingMovies(page);
        }
        return upcoming;
    }

    private HashMap<Integer, String> fetchGenresList(){
        if(mapGenres == null) {
            mapGenres = new HashMap<Integer, String>();
            Genre[] genres = API.getGenres();
            for(int i = 0 ; i < genres.length ; i++){
                Genre genre = genres[i];
                mapGenres.put(genre.getId(), genre.getName());
            }
        }
        return mapGenres;
    }

    private ArrayList<Movie> convertTMDbMoviesToMovies(com.fin.leo.movieholics.TMDb.entity.Movie[] TMDbMovies ){
        mapGenres = fetchGenresList();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for(int i = 0 ; i < TMDbMovies.length ; i++){
            com.fin.leo.movieholics.TMDb.entity.Movie TMDbMovie = TMDbMovies[i];
            Integer[] genderIds = TMDbMovie.getGenre_ids();
            String[] genders = new String[genderIds.length];
            for (int j = 0 ; j < genderIds.length ; j++) {
               genders[j] =  mapGenres.get(genderIds[j]);
            }
            String urlToPoster = API.getUrlRepositoryPoster() + TMDbMovie.getPoster_path();
            movies.add(new Movie(TMDbMovie.getTitle(), TMDbMovie.getId(), urlToPoster, genders, TMDbMovie.getOverview(), TMDbMovie.getRelease_date()));
        }
        return movies;
    }
}
