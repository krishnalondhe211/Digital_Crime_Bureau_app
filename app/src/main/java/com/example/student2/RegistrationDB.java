package com.example.student2;

public class RegistrationDB {
    String registerid;
    String name;
    String password;
    String email;
    String phonenumber;
    String cityname;
    String gender;

    public RegistrationDB() {

    }

    public RegistrationDB(String email, String registerid, String name, String password, String mobileno, String gender, String cityname)
    {
        this.email=email;
        this.registerid=registerid;
        this.name=name;
        this.password=password;
        this.phonenumber=mobileno;
        this.gender=gender;
        this.cityname=cityname;

    }

    public String getRegisterid() {
        return registerid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getCityname() {
        return cityname;
    }

    public String getGender() {
        return gender;
    }

    public void setRegisterid(String registerid) {
        this.registerid = registerid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
