package org.billboard.model;

import java.io.Serializable;

public class CinemaHall implements Serializable {
    private int cinemaHallId;
    private String hallName;
    private int numberOfRows;
    private int numberOfCols;

    public CinemaHall() {
    }

    public CinemaHall(int cinemaHallId,
                      String hallName,
                      int numberOfRows,
                      int numberOfCols) {
        this.cinemaHallId = cinemaHallId;
        this.hallName = hallName;
        this.numberOfRows = numberOfRows;
        this.numberOfCols = numberOfCols;
    }

    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfCols() {
        return numberOfCols;
    }

    public void setNumberOfCols(int numberOfCols) {
        this.numberOfCols = numberOfCols;
    }
}
