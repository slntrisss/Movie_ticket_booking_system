package org.billboard.model;

public class CinemaSeat {
    private int cinemaSeatId;
    private int reservedRowNumber;
    private int reservedSeatNumber;
    private String type;

    public CinemaSeat() {
    }

    public CinemaSeat(int cinemaSeatId,
                      int reservedRowNumber,
                      int reservedSeatNumber,
                      String type) {
        this.cinemaSeatId = cinemaSeatId;
        this.reservedRowNumber = reservedRowNumber;
        this.reservedSeatNumber = reservedSeatNumber;
        this.type = type;
    }

    public int getCinemaSeatId() {
        return cinemaSeatId;
    }

    public void setCinemaSeatId(int cinemaSeatId) {
        this.cinemaSeatId = cinemaSeatId;
    }

    public int getReservedRowNumber() {
        return reservedRowNumber;
    }

    public void setReservedRowNumber(int reservedRowNumber) {
        this.reservedRowNumber = reservedRowNumber;
    }

    public int getReservedSeatNumber() {
        return reservedSeatNumber;
    }

    public void setReservedSeatNumber(int reservedSeatNumber) {
        this.reservedSeatNumber = reservedSeatNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
