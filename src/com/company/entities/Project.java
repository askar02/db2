package com.company.entities;

public class Project {
    private int id;
    private String name;
    private int totalCost;

    public Project() {

    }

    public Project(int totalCost){
        this.setTotalCost(totalCost);
    }

    public Project(String name){
        this.setName(name);
    }

    public Project(String name, int totalCost) {
        setName(name);
        setTotalCost(totalCost);
    }

    public Project(int id, String name, int totalCost) {
        setId(id);
        setName(name);
        setTotalCost(totalCost);
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

    public int getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
