package com.kits.user.databaseexample;

/**
 * Created by User on 6/4/2016.
 */
public class Shop {

    private String name;
    private int id;
    private String address;

    public Shop(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {


        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
