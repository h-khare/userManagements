package com.users.users.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fname;
    private String lname;
    private String dob;
    private String city;
    private String mobile;
    public User() {
        super();
    }

    

    public int getId() {
        return id;
    }
  public User(int id, String fname, String lname, String dob, String city, String mobile) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.dob = dob;
    this.city = city;
    this.mobile = mobile;
}


  public void setId(int id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    @Override
    public String toString() {
        return "User [city=" + city + ", dob=" + dob + ", fname=" + fname + ", id=" + id + ", lname=" + lname
                + ", mobile=" + mobile + "]";
    }

    
    
}
