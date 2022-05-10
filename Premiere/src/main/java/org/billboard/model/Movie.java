package org.billboard.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int movieId;
    private String movieName;
    private String originalName;
    private String imageFile;

    public Movie() {
    }

    public Movie(int movieId,
                 String movieName,
                 String originalName,
                 String imageFile) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.originalName = originalName;
        this.imageFile = imageFile;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
