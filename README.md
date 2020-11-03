# Java 8 again

# using of Lambda Function in FileFilter

using anonymous function

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


using Lambda

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


