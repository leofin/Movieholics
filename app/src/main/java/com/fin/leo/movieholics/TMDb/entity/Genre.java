package com.fin.leo.movieholics.TMDb.entity;

public class Genre {
    private Integer id;
    private String name;

    public Genre(){
        super();
    }

    public Genre(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
