package org.billboard.model;

import java.io.Serializable;
import java.util.Date;

public class Detail implements Serializable {
    private int detailId;
    private String country;
    private String language;
    private int duration;
    private Date releaseDate;
    private String formattedDate;
    private String ageRating;
    private Double rating;
    private Integer numberOfVotes;
    private String description;

    public Detail() {
    }

    public Detail(int detailId,
                  String country,
                  String language,
                  int duration, Date releaseDate,
                  String formattedDate,
                  String ageRating,
                  Double rating,
                  Integer numberOfVotes,
                  String description) {
        this.detailId = detailId;
        this.country = country;
        this.language = language;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.formattedDate = formattedDate;
        this.ageRating = ageRating;
        this.rating = rating;
        this.numberOfVotes = numberOfVotes;
        this.description = description;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(Integer numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
