package org.billboard.service.dao;

import org.billboard.dto.schedule.AvailableInterval;
import org.billboard.dto.schedule.ScheduleDetail;
import org.billboard.filter.ScheduleFilter;
import org.billboard.model.Schedule;
import org.billboard.model.TicketType;
import org.billboard.repository.dao.ScheduleDao;
import org.billboard.service.trigger.DeleteEventListener;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ScheduleService implements DeleteEventListener{
    private final ScheduleDao scheduleRepo;
    private final DetailService detailService;
    private final TicketTypeService ticketTypeService;

    public ScheduleService(ScheduleDao scheduleRepo,
                           DetailService detailService,
                           TicketTypeService ticketTypeService) {
        this.scheduleRepo = scheduleRepo;
        this.detailService = detailService;
        this.ticketTypeService = ticketTypeService;
    }

    public List<Schedule> getSchedules(int movieId, int cinemaId){
        return scheduleRepo.getSchedules(movieId, cinemaId);
    }

    public List<Schedule> getSchedules(int movieId){
        return scheduleRepo.getSchedules(movieId);
    }

    public ScheduleDetail getSchedulesByFilter(ScheduleFilter filter){
        ScheduleDetail availableSchedules = new ScheduleDetail();
        List<Schedule> schedules = scheduleRepo.getSchedulesByFilter(filter);
        List<TicketType> ticketTypes = new LinkedList<>();
        for(Schedule schedule: schedules){
            ticketTypes.add(ticketTypeService.getTicket(schedule.getScheduleId()));
        }
        availableSchedules.setSchedules(schedules);
        availableSchedules.setTicketTypes(ticketTypes);
        return availableSchedules;
    }

    public List<AvailableInterval> getAvailableIntervals(ScheduleFilter filter){
        List<Schedule> schedules = scheduleRepo.getAvailableTimeIntervals(filter);
        int duration = detailService.getDuration(filter.getMovieId());
        return getAvailableIntervals(schedules, duration);
    }

    public void saveSchedules(ScheduleDetail scheduleDetail, int cinemaHallId, int movieId){
        List<Schedule> schedules = scheduleDetail.getSchedules();
        List<TicketType> ticketTypes = scheduleDetail.getTicketTypes();
        for(int i = 0; i < schedules.size(); i++){
            ticketTypeService.save(ticketTypes.get(i), schedules.get(i).getScheduleId());
        }
        scheduleRepo.save(schedules, cinemaHallId, movieId);
    }

    private List<AvailableInterval> getAvailableIntervals(List<Schedule> schedules, int duration){
        List<AvailableInterval> list = new LinkedList<>();
        StringBuilder baseStart = new StringBuilder()
                .append(new LocalDate())
                .append("T")
                .append("10:00");
        StringBuilder baseEnd = new StringBuilder()
                .append(new LocalDate())
                .append("T")
                .append("10:00");

        for(Schedule schedule: schedules){
            StringBuilder startTime = new StringBuilder()
                    .append(new LocalDate())
                    .append("T")
                    .append(schedule.getStartTime());

            LocalDateTime start = LocalDateTime.parse(startTime.toString());
            LocalDateTime end = new LocalDateTime(start.toDate().getTime() + 123 * 60 * 1000);


            Interval interval1 = getInterval(baseStart.toString(), baseEnd.toString());
            Interval interval2 = getInterval(start.toString(), end.toString());

            Interval gap = new Interval(interval1.gap(interval2));
            addInterval(gap, duration, list);

            baseStart = startTime;
            baseEnd = new StringBuilder(end.toString());
        }
        return list;
    }
    private Interval getInterval(String start, String end){
        Instant startInterval = new Instant(start);
        Instant endInterval = new Instant(end);
        return new Interval(startInterval, endInterval);
    }

    private void addInterval(Interval gap, int duration, List<AvailableInterval> list){
        int startHour = Integer.parseInt(gap.getStart().hourOfDay().getAsShortText());
        int startMin = Integer.parseInt(gap.getStart().minusHours(gap.getStart()
                .getHourOfDay()).minuteOfDay().getAsShortText());

        int startTimeInMin = startHour * 60 + startMin;


        int endHour = Integer.parseInt(gap.getEnd().hourOfDay().getAsShortText());
        int endMin = Integer.parseInt(gap.getEnd().minusHours(gap.getEnd()
                .getHourOfDay()).minuteOfDay().getAsShortText());

        int endTimeInMin = endHour * 60 + endMin;

        if(endTimeInMin - startTimeInMin >= duration){
            StringBuilder start = new StringBuilder();
            start.append(startHour).append(":");
            if(startMin < 10)
                start.append("0").append(startMin);
            else
                start.append(startMin);
            StringBuilder end = new StringBuilder();
            end.append(endHour).append(":");
            if(endMin < 10)
                end.append("0").append(endMin);
            else
                end.append(endMin);

            AvailableInterval availableInterval =
                    new AvailableInterval(start.toString(), end.toString());
            list.add(availableInterval);
        }
    }

    @Override
    public void notifyDelete(int id) {
        ticketTypeService.delete(id);
        scheduleRepo.deleteByMovieId(id);
    }

    public void delete(int id){
        ticketTypeService.delete(id);
        scheduleRepo.delete(id);
    }

    public void deleteByHallId(int hallId){
        List<Integer> schedules = scheduleRepo.getSchedulesByHallId(hallId);
        for(Integer e: schedules)
            ticketTypeService.delete(e);
        scheduleRepo.deleteByHallId(hallId);
    }
}
