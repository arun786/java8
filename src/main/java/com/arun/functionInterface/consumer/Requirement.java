package com.arun.functionInterface.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author arun on 11/7/20
 */
public class Requirement {

    public static void main(String[] args) {
        //add the list of names in list 1 and list 2 one after the other and then print the list
        List<Integer> names = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Consumer<Integer> c1 = list1::add;
        Consumer<Integer> c2 = list2::add;
        Consumer<Integer> c3 = System.out::println;

        Consumer<Integer> c4 = c1.andThen(c2).andThen(c3);
        names.forEach(c4);

        assert list1.size() == 7;
        assert list2.size() == 7;
    }
}
