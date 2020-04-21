package com.example.student2;

public class Appointment_DB {
    String fullname,gender,date,time,reason,district,station;
    public  Appointment_DB()
    {

    }
    public Appointment_DB(String fullname,String gender,String date,String time,String reason,String district,String station){
        this.fullname=fullname;
        this.gender=gender;
        this.date=date;
        this.time=time;
        this.reason=reason;
        this.district=district;
        this.station=station;
    }

    public String getFullname() {
        return fullname;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public String getDistrict() {
        return district;
    }

    public String getStation() {
        return station;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
