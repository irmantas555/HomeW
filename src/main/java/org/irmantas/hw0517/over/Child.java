package org.irmantas.hw0517.over;

public class Child extends MyParent{
        private String myMother;

    public Child(String myMother) {
        this.myMother = myMother;
    }

    public Child(int id, String name, String myMother) {
        super(id, name);
        this.myMother = myMother;
    }

    public String getMyMother() {
        return myMother;
    }

    @Override
    public void increaseID() {
        super.id += 5;
    }

    @Override
    public void increaseID(int increaseValue) {
        super.increaseID(increaseValue + 5);
    }
}
