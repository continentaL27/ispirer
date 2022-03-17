package com.conti.stage1;

public class SomeObject {

    private static int count = 0;

    private int x;
    private int y;
    public String description;

    {
        count++;
    }

    public SomeObject() {
    }

    public SomeObject(int x, int y, String description) {
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public static int amountOfInstances() {
        return count;
    }
}
