package com.arun.functionInterface.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author arun on 11/7/20
 */
public class ChainConsumers {

    //Consumer takes in a parameter and returns a void

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("One", "Two", "Three", "Four", "Five");

        Consumer<String> c1 = System.out::println;
        strings.forEach(c1);

        //forEach takes a consumer

        List<String> numbers = new ArrayList<>();

        //requirement is to display all the numbers of Strings list and also to the list to numbers lists.
        Consumer<String> c2 = numbers::add;
        Consumer<String> c3 = c1.andThen(c2);

        strings.forEach(c3);
        assert numbers.size() == 5;
    }
}
