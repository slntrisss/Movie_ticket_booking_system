package org.billboard.filter;

public class ScheduleFilter {
    private int cinemaId;
    private int movieId;
    private int cinemaHallId;

    public ScheduleFilter() {
    }

    public ScheduleFilter(int cinemaId,
                          int movieId,
                          int cinemaHallId) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
