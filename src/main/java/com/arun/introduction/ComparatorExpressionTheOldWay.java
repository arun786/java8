package com.arun.introduction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author arun on 11/2/20
 */

public class ComparatorExpressionTheOldWay {

    public static void main(String[] args) {

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        List<String> list = Arrays.asList("**", "*", "****", "*****", "***");

        list.sort(comp);
        System.out.println(list);
    }
}
