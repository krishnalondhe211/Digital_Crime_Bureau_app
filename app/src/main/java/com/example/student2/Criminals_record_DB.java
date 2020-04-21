package com.example.student2;

public class Criminals_record_DB {



    public String fullname_c,gender_c,age_c,mobileno_c,address1_c,alternateAddress_c,pastrecord_c;
    public Criminals_record_DB(){

    }

    public Criminals_record_DB(String fullname_c, String gender_c, String age_c, String mobileno_c, String address1_c, String alternateAddress_c, String pastrecord_c) {
        this.fullname_c = fullname_c;
        this.gender_c = gender_c;
        this.age_c = age_c;
        this.mobileno_c = mobileno_c;
        this.address1_c = address1_c;
        this.alternateAddress_c = alternateAddress_c;
        this.pastrecord_c = pastrecord_c;
    }

    public String getFullname_c() {
        return fullname_c;
    }

    public String getGender_c() {
        return gender_c;
    }

    public String getAge_c() {
        return age_c;
    }

    public String getMobileno_c() {
        return mobileno_c;
    }

    public String getAddress1_c() {
        return address1_c;
    }

    public String getAlternateAddress_c() {
        return alternateAddress_c;
    }

    public String getPastrecord_c() {
        return pastrecord_c;
    }

    public void setFullname_c(String fullname_c) {
        this.fullname_c = fullname_c;
    }

    public void setGender_c(String gender_c) {
        this.gender_c = gender_c;
    }

    public void setAge_c(String age_c) {
        this.age_c = age_c;
    }

    public void setMobileno_c(String mobileno_c) {
        this.mobileno_c = mobileno_c;
    }

    public void setAddress1_c(String address1_c) {
        this.address1_c = address1_c;
    }

    public void setAlternateAddress_c(String alternateAddress_c) {
        this.alternateAddress_c = alternateAddress_c;
    }

    public void setPastrecord_c(String pastrecord_c) {
        this.pastrecord_c = pastrecord_c;
    }
}
