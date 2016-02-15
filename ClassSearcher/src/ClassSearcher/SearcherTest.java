package ClassSearcher;

import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearcherTest {

    @org.junit.Test
    public void testRefresh() throws Exception {
        Searcher searcher = new Searcher();
        String[] classes = new String[] {
                "aaa", "bbb", "ccc",
                "aab", "aac", "abc"
        };
        long[] modificationDates = new long[] {
                2, 3, 5,
                1, 7, 10
        };
        searcher.refresh(classes, modificationDates);
    }

    @org.junit.Test
    public void testGuess() throws Exception {
        Searcher searcher = new Searcher();
        String[] classes = new String[] {
                "aaa", "bbb", "ccc",
                "aab", "aac", "abc"
        };
        long[] modificationDates = new long[] {
                2, 3, 5,
                1, 7, 10
        };
        searcher.refresh(classes, modificationDates);
        System.out.println(Arrays.toString(searcher.guess("a")));

        SecureRandom random = new SecureRandom();
        Writer classesFileGenerator = new FileWriter("./src/classes.txt");
        for (int i = 0; i < 100000; i++) {
            classesFileGenerator.write(new BigInteger(256, random).toString(32));
            classesFileGenerator.write("\n");
        }
        classesFileGenerator.close();
        Writer datesFileGenerator = new FileWriter("./src/modificationDates.txt");
        for (int i = 0; i < 100000; i++) {
            datesFileGenerator.write(new BigInteger(32, random).toString());
            datesFileGenerator.write("\n");
        }
        datesFileGenerator.close();

        List<String> classesList = (new BufferedReader(
                new FileReader("./src/classes.txt")))
                .lines()
                .collect(Collectors.toList());
        classes = new String[classesList.size()];
        for (int i = 0; i < classesList.size(); i++)
            classes[i] = classesList.get(i);
        List<Long> modificationDatesList = (new BufferedReader(
                new FileReader("./src/modificationDates.txt")))
                .lines()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        modificationDates = new long[modificationDatesList.size()];
        for (int i = 0; i < modificationDatesList.size(); i++)
            modificationDates[i] = modificationDatesList.get(i);

        long startTime = System.currentTimeMillis();
        searcher.refresh(classes, modificationDates);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");

//        System.out.println(Arrays.toString(modificationDates));
//        System.out.println(Arrays.toString(classes));
        startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(searcher.guess("lal")));
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(searcher.guess("a")));
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }
}