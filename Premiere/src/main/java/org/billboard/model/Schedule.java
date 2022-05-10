package org.billboard.model;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {
    private int scheduleId;
    private Date scheduleDate;
    private String startTime;

    public Schedule() {
    }

    public Schedule(int scheduleId,
                    Date scheduleDate,
                    String startTime) {
        this.scheduleId = scheduleId;
        this.scheduleDate = scheduleDate;
        this.startTime = startTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
