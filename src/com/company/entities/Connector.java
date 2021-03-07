package com.company.entities;

public class Connector {
    private int id;
    private int necklace_id;
    private int stone_id;
    //variables

    public Connector() {

    }//class structure

    public Connector(int id, int necklace_id, int stone_id){//method
        setId(id);
        setStone_id(stone_id);
        setNecklace_id(necklace_id);
    }
    public Connector(int necklace_id, int stone_id){//method
        setStone_id(stone_id);
        setNecklace_id(necklace_id);
    }

    //getter and setters
    public int getId() {
        return id;
    } //Method, which returns id of connector
    public void setId(int id) {
        this.id = id;
    } //Method, which changes the id of connector

    public int getStone_id() {
        return stone_id;
    } //Method, which returns id of stone
    public void setStone_id(int stone_id) {
        this.stone_id = stone_id;
    } //Method, which changes the id of stone

    public int getNecklace_id() {
        return necklace_id;
    } //Method, which returns id of necklace
    public void setNecklace_id(int necklace_id) {
        this.necklace_id = necklace_id;
    } //Method, which changes the id of necklace

    //override for toString
    @Override
    public String toString(){
        return "Connector{" +
                "Id=" + id +
                ", Necklace id='" + necklace_id + '\'' +
                ", Stone id='" + stone_id +
                '}';
    }
}