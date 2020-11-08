package com.arun.introduction;

import java.io.File;
import java.io.FileFilter;

/**
 * @author arun on 11/2/20
 */

public class FileFilterExpressionUsingAnonymousClass {

    public static void main(String[] args) {

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File dir = new File("/Users/arun/learning/java/java8/src/main/java/com/arun/introduction");
        File[] files = dir.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("No files found");
        }

    }
}
