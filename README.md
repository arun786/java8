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


## thread example

    package com.arun.introduction;
    
    /**
     * @author arun on 11/2/20
     */
    public class RunnableUsingTraditionalWay {
    
        public static void main(String[] args) throws InterruptedException {
    
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Thread " + i + " : " + Thread.currentThread());
                    }
                }
            };
    
            Thread thread = new Thread(run);
            thread.start();
            thread.join();
        }
    }


Thread with Lambda

    package com.arun.introduction;
    
    /**
     * @author arun on 11/2/20
     */
    public class ThreadWithLambda {
    
        public static void main(String[] args) throws InterruptedException {
    
            Runnable run = () -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Thread " + i + " : " + Thread.currentThread());
                }
            };
    
            Thread t = new Thread(run);
    
            t.start();
            t.join();
        }
    }


## Comparator Example


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


 Lambda way
 
    package com.arun.introduction;
    
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;
    
    /**
     * @author arun on 11/2/20
     */
    
    public class ComparatorWithLambda {
    
        public static void main(String[] args) {
    
            Comparator<String> comp = (s1,s2) -> Integer.compare(s1.length(),s2.length());
            List<String> list = Arrays.asList("**", "*", "****", "*****", "***");
    
            list.sort(comp);
            System.out.println(list);
        }
    }

New way

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

