package org.billboard.dto.movie;

import org.billboard.model.Detail;
import org.billboard.model.Genre;
import org.billboard.model.Movie;
import org.billboard.model.RoleDetail;

import java.util.List;

public class MovieDetail {
    private Movie movie;
    private Detail detail;
    private List<RoleDetail> roleDetails;
    private List<Genre> genres;

    public MovieDetail() {
    }

    public MovieDetail(Movie movie,
                       Detail detail,
                       List<RoleDetail> roleDetails,
                       List<Genre> genres) {
        this.movie = movie;
        this.detail = detail;
        this.roleDetails = roleDetails;
        this.genres = genres;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<RoleDetail> getRoleDetails() {
        return roleDetails;
    }

    public void setRoleDetails(List<RoleDetail> roleDetails) {
        this.roleDetails = roleDetails;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
