package com.company.entities;

public class Stone {
    private int id;
    private String name;
    private double weight;
    private int cost;//variables

    public Stone(){

    }

    public Stone(String name, double weight, int cost){
        setName(name);
        setCost(cost);
    }

    public Stone(int id, String name, double weight, int cost){//method
        setId(id);
        setName(name);
        setCost(cost);
    }

    public int getId() {
        return id;
    } //getter of id

    public void setId(int id) {
        this.id = id;
    } //setter of id

    public double getWeight() {
        return weight;
    } //getter of weight

    public void setWeight(double weight) {
        this.weight = weight;
    } //setter of weight

    public int getCost() {
        return cost;
    } //getter of cost

    public void setCost(int cost) {
        this.cost = cost;
    } //setter of cost

    public String getName() {
        return name;
    } //getter of name

    public void setName(String name) {
        this.name = name;
    } //setter of name

    //override for toString
    @Override
    public String toString(){
        return "Stone{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", weight='" + weight +
                '}';
    }
}