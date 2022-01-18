package com.example.sdproject;

public class Shipping {

    String Name ,Division ,Location ,Mail ,Phone ;

    public Shipping()
    {

    }

    public Shipping(String name, String division, String location, String mail, String phone) {
        Name = name;
        Division = division;
        Location = location;
        Mail = mail;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
