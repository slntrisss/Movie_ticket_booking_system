package org.billboard.dto.home;

import org.billboard.model.Genre;
import org.billboard.model.Movie;

import java.util.Date;
import java.util.List;

public class MoviePoster {
    private Movie movie;
    private Date releaseDate;
    private String formattedDate;
    private List<Genre> genres;

    public MoviePoster() {
    }

    public MoviePoster(Movie movie,
                       Date releaseDate,
                       String formattedDate,
                       List<Genre> genres) {
        this.movie = movie;
        this.releaseDate = releaseDate;
        this.formattedDate = formattedDate;
        this.genres = genres;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
