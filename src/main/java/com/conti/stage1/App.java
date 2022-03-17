package com.conti.stage1;

public class App {

    public static void main(String[] args) {

        SomeObject obj1 = new SomeObject();
        SomeObject obj2 = new SomeObject();
        SomeObject obj3 = new SomeObject(1, 2, "test");
        SomeObject obj4 = new SomeObject(2, 3, "test2");

        int amountOfInstances = SomeObject.amountOfInstances();

        System.out.printf("SomeObject.class amount of instances = %s", amountOfInstances);

    }
}
