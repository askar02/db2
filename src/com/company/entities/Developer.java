package com.company.entities;

public class Developer {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private int salary;

    public Developer() {

    }

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


    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }


    public boolean getGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

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
