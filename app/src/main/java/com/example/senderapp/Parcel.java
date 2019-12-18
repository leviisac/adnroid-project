package com.example.senderapp;

import java.util.Date;

public class Parcel {

    static int IdNumber =1;
    private int Id;
    private String Location;
    private String Type;
    private String Weight;
    private boolean Fragile;
    private String Name;
    private String Address;
    private String SendDate;
    private String ExpectedDate;
    private String PhoneNumber;
    private String Email;


    public void setLocation(String location) {
        Location = location;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public void setFragile(boolean fragile) {
        Fragile = fragile;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setSendDate(String sendDate) {
        SendDate = sendDate;
    }

    public void setExpectedDate(String expectedDate) {
        ExpectedDate = expectedDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLocation() {
        return Location;
    }

    public String getType() {
        return Type;
    }

    public String getWeight() {
        return Weight;
    }

    public boolean isFragile() {
        return Fragile;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getSendDate() {
        return SendDate;
    }

    public String getExpectedDate() {
        return ExpectedDate;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Parcel(String location, String type, String weight, boolean fragile, String name, String address, String sendDate, String expectedDate, String phoneNumber, String email) {
        Location = location;
        Type = type;
        Weight = weight;
        Fragile = fragile;
        Name = name;
        Address = address;
        SendDate = sendDate;
        ExpectedDate = expectedDate;
        PhoneNumber = phoneNumber;
        Email = email;
        Id = IdNumber;
        IdNumber++;
    }
}
