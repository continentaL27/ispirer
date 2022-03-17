package com.conti.stage2;


public class App {

    public static void main(String[] args) {

        SomeList<String> lines = new SomeList<>();

        lines.add( "hello");
        lines.add("h1");
        lines.add("jb");
        lines.addChangedListener();
        lines.add("bs");
//        System.out.println(lines);

        SomeList<Integer> numbers = new SomeList<>();
        numbers.addChangedListener();
        numbers.add(1);
        numbers.add(2);
        numbers.add(6);
        numbers.removeChangedListener();
        numbers.add(7);
        numbers.add(8);

//        System.out.println(numbers);
    }
}
