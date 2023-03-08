package com.hussain.utils;

import java.util.*;

public class Addition {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);


        System.out.println(sum(list));
        System.out.println(add(list));

        System.out.println(avg(list));
    }

    private static double avg(List<Integer> list) {
        OptionalDouble doube = list.stream().filter(o -> o > 5).mapToDouble(o -> o).average();
        return doube.getAsDouble();
    }

    private static int add(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int result = 0;
        while (it.hasNext()) {
            Integer num = it.next();
            if (num > 5) {
                result = result + num;
            }
        }
        return result;
    }

    public static int sum(List<Integer> list) {
        return list.stream().filter(i -> i > 5).filter(o -> o < 9).mapToInt(i -> i).sum();
    }
}