package com.arun.introduction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author arun on 11/2/20
 */

public class ComparatorExpressionTheNewLambdaWay {

    public static void main(String[] args) {

        Comparator<String> comp = Comparator.comparingInt(String::length);

        List<String> list = Arrays.asList("**", "*", "****", "*****", "***");

        list.sort(comp);
        System.out.println(list);
    }
}
