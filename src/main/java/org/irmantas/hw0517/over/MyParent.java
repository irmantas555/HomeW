package org.irmantas.hw0517.over;

public class MyParent {
    protected int id;
    protected String name;

    public MyParent() {
    }

    public MyParent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void increaseID() {
        id++;
    }

    public void increaseID(int increaseValue) {
        id += increaseValue;
    }
}
