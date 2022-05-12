package org.billboard.dto.scheduleSort;

import org.billboard.model.Cinema;
import org.billboard.model.Movie;
import org.billboard.model.Schedule;
import org.billboard.model.TicketType;

import java.util.List;

public class CinemaMovieSchedule {
    private Cinema cinema;
    private Movie movie;
    private List<Schedule> schedules;
    private List<String> hallName;
    private String language;
    private List<TicketType> ticketTypes;

    public CinemaMovieSchedule() {
    }

    public CinemaMovieSchedule(Cinema cinema,
                               Movie movie,
                               List<Schedule> schedules,
                               List<String> hallName,
                               String language,
                               List<TicketType> ticketTypes) {
        this.cinema = cinema;
        this.movie = movie;
        this.schedules = schedules;
        this.hallName = hallName;
        this.language = language;
        this.ticketTypes = ticketTypes;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<String> getHallName() {
        return hallName;
    }

    public String getLanguage() {
        return language;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public static class CinemaMovieScheduleBuilder {
        private Cinema cinema;
        private Movie movie;
        private List<Schedule> schedules;
        private List<String> hallName;
        private String language;
        private List<TicketType> ticketTypes;

        public CinemaMovieScheduleBuilder setCinema(Cinema cinema) {
            this.cinema = cinema;
            return this;
        }

        public CinemaMovieScheduleBuilder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }

        public CinemaMovieScheduleBuilder setSchedules(List<Schedule> schedules) {
            this.schedules = schedules;
            return this;
        }

        public CinemaMovieScheduleBuilder setHallName(List<String> hallName) {
            this.hallName = hallName;
            return this;
        }

        public CinemaMovieScheduleBuilder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public CinemaMovieScheduleBuilder setTicketTypes(List<TicketType> ticketTypes) {
            this.ticketTypes = ticketTypes;
            return this;
        }

        public CinemaMovieSchedule build(){
            return new CinemaMovieSchedule(cinema, movie, schedules,
                     hallName, language, ticketTypes);
        }
    }
}