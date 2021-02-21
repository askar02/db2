package com.company.entities;

public class Developer {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private int salary;

    public Developer() {

    } //class structure

    public Developer(String name, String surname, boolean gender, int salary) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setSalary(salary);
    }

    public Developer(int id, String name, String surname, boolean gender, int salary) {
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setSalary(salary);
    }

    public int getId() {
        return id;
    } //Method, which returns id of developer
    public void setId(int id) {
        this.id = id;
    } //Method, which changes the id of developer


    public String getName() {
        return name;
    } //Method, which returns name of developer
    public void setName(String name) {
        this.name = name;
    } //Method, which changes name of developer


    public String getSurname() {
        return surname;
    } //Method, which returns surname of developer
    public void setSurname(String surname) {
        this.surname = surname;
    } //Method, which changes the id of developer


    public boolean getGender() {
        return gender;
    }//Method, which returns gender of developer
    public void setGender(boolean gender) {
        this.gender = gender;
    } //Method, which changes the gender of developer


    public int getSalary() {
        return salary;
    }//Method, which returns salary of developer
    public void setSalary(int salary) {
        this.salary = salary;
    } //Method, which changes the salary of developer


    /**
     * toString
     *structure of output of each developer in console
     */
    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }

}
