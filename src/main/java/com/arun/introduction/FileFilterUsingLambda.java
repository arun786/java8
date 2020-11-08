package com.arun.introduction;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author arun on 11/2/20
 */

public class FileFilterUsingLambda {

    public static void main(String[] args) {

        FileFilter fileFilter = file -> file.getName().endsWith(".java");

        File dir = new File("/Users/arun/learning/java/java8/src/main/java/com/arun/introduction");
        File[] files = dir.listFiles(fileFilter);

        List<File> list = new ArrayList<>();
        if (files != null) {
            list.addAll(Arrays.asList(files));
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

}
