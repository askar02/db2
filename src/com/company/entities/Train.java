package com.company.entities;

public class Train {
    private int id;
    private String name;
    private int capacity;
    private int locomotiveID;
    public Train(){

    }


    public Train(String name, int capacity, int locomotiveID){
        setName(name);
        setCapacity(capacity);
        setLocomotiveID(locomotiveID);
    }

    public Train(int id, String name, int capacity, int locomotiveID){
        setId(id);
        setName(name);
        setCapacity(capacity);
        setLocomotiveID(locomotiveID);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLocomotiveID() {
        return locomotiveID;
    }

    public void setLocomotiveID(int locomotiveID) {
        this.locomotiveID = locomotiveID;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", locomotiveID=" + locomotiveID +
                '}';
    }
}
