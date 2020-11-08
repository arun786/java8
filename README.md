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

## Consumers

### Example 1

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

### Example 2

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
