package com.example.student2;

public class Complaint_DB {
    String  date,time,crime_type,district,station,suspect_name,suspect_gender,suspect_age,suspect_address,suspect_info;
    public Complaint_DB(){

    }
    public Complaint_DB(String crime_type,String district,String station,String date,String time,String suspect_name,String suspect_gender,String suspect_age,String suspect_address,String suspect_info) {

        this.crime_type=crime_type;
        this.district=district;
        this.station=station;
        this.date=date;
        this.time=time;
        this.suspect_name=suspect_name;
        this.suspect_gender=suspect_gender;
        this.suspect_age=suspect_age;
        this.suspect_address=suspect_address;
        this.suspect_info=suspect_info;

    }

    public String getcrime_type() {
        return crime_type;
    }

    public String getdistrict() {
        return district;
    }

    public String getstation() {
        return station;
    }

    public String getdate() {
        return date;
    }

    public String gettime() {
        return time;
    }

    public String getsuspect_name() {
        return suspect_name;
    }

    public String getsuspect_gender() {
        return suspect_gender;
    }

    public String getsuspect_age() {
        return suspect_age;
    }

    public String getsuspect_address() {
        return suspect_address;
    }

    public String getsuspect_info() {
        return suspect_info;
    }


    public void setcrime_type(String crime_type) {
        this.crime_type = crime_type;
    }

    public void setdistrict(String district) {
        this.district = district;
    }

    public void setstation(String station) {
        this.station = station;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public void settime(String time) {
        this.time = time;
    }

    public void setsuspect_name(String suspect_name) {
        this.suspect_name = suspect_name;
    }

    public void setsuspect_gender(String suspect_gender) {
        this.suspect_gender = suspect_gender;
    }

    public void setsuspect_age(String suspect_age) {
        this.suspect_age = suspect_age;
    }

    public void setsuspect_address(String suspect_address) {
        this.suspect_address = suspect_address;
    }

    public void setsuspect_info(String suspect_info) {
        this.suspect_info = suspect_info;
    }
}
