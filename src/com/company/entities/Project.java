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
    } //Method, which returns id of project
    public void setId(int id) {
        this.id = id;
    } //Method, which changes the id of project

    public String getName() {
        return name;
    } //Method, which returns name of project
    public void setName(String name) {
        this.name = name;
    } //Method, which changes the name of project

    public int getTotalCost() {
        return totalCost;
    } //Method, which returns totalCost of project
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }//Method, which changes the totalCost of project

    /**
     * toString
     *structure of output of each project in console
     */
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
