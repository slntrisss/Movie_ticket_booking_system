package org.billboard.model;


import java.io.Serializable;

public class Cinema implements Serializable {
    private int cinemaId;
    private String cinemaName;
    private String address;
    private String phone;
    private String info;
    private String startOfWork;
    private String endOfWork;
    private String imageFile;

    public Cinema() {
    }

    public Cinema(int cinemaId,
                  String cinemaName,
                  String address,
                  String phone,
                  String info,
                  String startOfWork,
                  String endOfWork,
                  String imageFile) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
        this.phone = phone;
        this.info = info;
        this.startOfWork = startOfWork;
        this.endOfWork = endOfWork;
        this.imageFile = imageFile;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getInfo() {
        return info;
    }

    public String getStartOfWork() {
        return startOfWork;
    }

    public String getEndOfWork() {
        return endOfWork;
    }

    public String getImageFile() {
        return imageFile;
    }

    public static class CinemaBuilder{
        private int cinemaId;
        private String cinemaName;
        private String address;
        private String phone;
        private String info;
        private String startOfWork;
        private String endOfWork;
        private String imageFile;

        public CinemaBuilder(){}

        public CinemaBuilder setCinemaId(int cinemaId){
            this.cinemaId = cinemaId;
            return this;
        }

        public CinemaBuilder setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
            return this;
        }

        public CinemaBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public CinemaBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public CinemaBuilder setInfo(String info) {
            this.info = info;
            return this;
        }

        public CinemaBuilder setStartOfWork(String startOfWork) {
            this.startOfWork = startOfWork;
            return this;
        }

        public CinemaBuilder setEndOfWork(String endOfWork) {
            this.endOfWork =endOfWork;
            return this;
        }

        public CinemaBuilder setImageFile(String imageFile) {
            this.imageFile = imageFile;
            return this;
        }

        public Cinema build(){
            return new Cinema(cinemaId, cinemaName, address,
                    phone, info, startOfWork, endOfWork, imageFile);
        }
    }
}
