package org.billboard.service.dto;

import org.billboard.dto.scheduleSort.CinemaMovieSchedule;
import org.billboard.model.Cinema;
import org.billboard.model.Movie;
import org.billboard.model.Schedule;
import org.billboard.model.TicketType;
import org.billboard.service.dao.*;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ScheduleOrderService {
    private final ScheduleService scheduleService;
    private final MovieService movieService;
    private final CinemaService cinemaService;
    private final CinemaHallService hallService;
    private final DetailService detailService;
    private final TicketTypeService ticketService;

    public ScheduleOrderService(ScheduleService scheduleService,
                                MovieService movieService,
                                CinemaService cinemaService,
                                CinemaHallService hallService,
                                DetailService detailService,
                                TicketTypeService ticketService) {
        this.scheduleService = scheduleService;
        this.movieService = movieService;
        this.cinemaService = cinemaService;
        this.hallService = hallService;
        this.detailService = detailService;
        this.ticketService = ticketService;
    }

    public List<CinemaMovieSchedule> getMovieSchedules(int movieId){
        List<Cinema> cinemas = cinemaService.getCinemaOrders(movieId);
        List<CinemaMovieSchedule> schedules = new LinkedList<>();
        String language = detailService.getAllLanguages(movieId);
        for(int i = 0; i < cinemas.size(); i++){
            int cinemaId = cinemas.get(i).getCinemaId();

            List<Schedule> scheduleList = scheduleService.getSchedules(movieId, cinemaId);
            if(scheduleList.size() == 0)
                continue;
            List<String> halls = new LinkedList<>();
            List<TicketType> tickets = new LinkedList<>();
            for(Schedule schedule: scheduleList){
                tickets.add(ticketService.getTicket(schedule.getScheduleId()));
                halls.add(hallService.getHallByScheduleId(schedule.getScheduleId()));
            }

            CinemaMovieSchedule cinemaMovieSchedule = new CinemaMovieSchedule.CinemaMovieScheduleBuilder()
                    .setCinema(cinemas.get(i))
                    .setLanguage(language)
                    .setHallName(halls)
                    .setSchedules(scheduleList)
                    .setTicketTypes(tickets)
                    .build();
            schedules.add(cinemaMovieSchedule);
        }
        return schedules;
    }

    public List<CinemaMovieSchedule> getCinemaSchedule(int cinemaId){
        List<Movie> movies = movieService.getAllMoviesByCinemaId(cinemaId);
        List<CinemaMovieSchedule> cinemaMovieSchedules = new LinkedList<>();
        String language = detailService.getAllLanguages(movies.get(0).getMovieId());

        for(int i = 0; i < movies.size(); i++){
            int movieId = movies.get(i).getMovieId();
            List<Schedule> scheduleList = scheduleService.getSchedules(movieId, cinemaId);
            if(scheduleList.size() == 0)
                continue;
            List<String> halls = new LinkedList<>();
            List<TicketType> tickets = new LinkedList<>();
            for(Schedule schedule: scheduleList){
                tickets.add(ticketService.getTicket(schedule.getScheduleId()));
                halls.add(hallService.getHallByScheduleId(schedule.getScheduleId()));
            }

            CinemaMovieSchedule cinemaMovieSchedule = new CinemaMovieSchedule.CinemaMovieScheduleBuilder()
                    .setMovie(movies.get(i))
                    .setSchedules(scheduleList)
                    .setHallName(halls)
                    .setLanguage(language)
                    .setTicketTypes(tickets)
                    .build();

            cinemaMovieSchedules.add(cinemaMovieSchedule);
        }
        return cinemaMovieSchedules;
    }
}
