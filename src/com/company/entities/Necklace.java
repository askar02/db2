package com.company.entities;

import java.util.List;

public class Necklace {
    private int id;
    private String name;
    private double weight;
    private int cost;
    private List<Stone> stoneList;
    //variables

    public Necklace() {

    }

    public Necklace(String name, double weight, int cost){
        setName(name);
        setCost(cost);
    }

    public Necklace(int id, String name, double weight, int cost){
        setId(id);
        setName(name);
        setCost(cost);
    }

    //getter and setters
    public int getId() {
        return id;
    } //Method, which returns id of necklace
    public void setId(int id) {
        this.id = id;
    } //Method, which changes the id of necklace

    public double getWeight() {
        return weight;
    } //Method, which returns weight of necklace
    public void setWeight(double weight) {
        this.weight = weight;
    } //Method, which changes the weight of necklace

    public int getCost() {
        return cost;
    } //Method, which returns cost of necklace
    public void setCost(int cost) {
        this.cost = cost;
    } //Method, which changes the cost of necklace

    public String getName() {
        return name;
    } //Method, which returns name of necklace
    public void setName(String name) {
        this.name = name;
    } //Method, which changes the name of necklace

    public List<Stone> getStoneList() { return stoneList; } //Method, which returns name of necklace
    public void setStoneList(List<Stone> stoneList) {
        this.stoneList = stoneList;
    } //Method, which changes the name of necklace



    //override for toString
    @Override
    public String toString(){
        return "Necklace{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", cost='" + cost +
                '}';
    }
}