package com.sakila.models;

import java.util.ArrayList;
import java.util.List;

 
public class Film {
    private int id;
    private String title;
    private String description;
    private int releaseYear;
    private int language_id;

    private List<Actor> actors;


    public Film(int id, String title, String description, int releaseYear, int language_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.actors = new ArrayList<>();
        this.language_id = language_id;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public int getLanguage() {
        return language_id;
    }

    public void setLanguage(int language_id) {
        this.language_id = language_id ;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public List<Actor> getActors() {
        return actors;
    }
}
