package com.company.entities;

public class Locomotive {
    private int id;
    private String name;
    public Locomotive(){

    }

    public Locomotive(String name){
        setName(name);
    }

    public Locomotive(int id, String name){
        setId(id);
        setName(name);
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
    @Override
    public String toString() {
        return "Locomotive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
