package com.wenqi.learn.chapter7.item45;

import org.apache.ibatis.cache.decorators.FifoCache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Prints all large anagram groups in a dictionary iteratively
 * 迭代地打印字典中的所有大字谜组
 *
 * @author liangwenqi
 * @date 2022/2/17
 */
public class Anagrams {
    public static void main(String[] args) throws FileNotFoundException {
        normal(args);
    }

    /**
     * 普通实现
     *
     * @param args
     * @throws FileNotFoundException
     */
    private static void normal(String[] args) throws FileNotFoundException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ":" + group);
            }
        }
    }

    /**
     * Overuse of streams - don't do this!
     * <p>
     * stream实现
     *
     * @param args
     * @throws FileNotFoundException
     */
    private static void withStream(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(
                    Collectors.groupingBy(word -> word.chars().sorted().collect(StringBuilder::new, (sb, c) -> sb.append((char) c),
                            StringBuilder::append).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
    }

    /**
     * Tasteful use of streams enhances clarity and conciseness
     *
     * stream实现
     * @param args
     * @throws IOException
     */
    private static void betterWithStream(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(Collectors.groupingBy(word -> alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
        }
    }


    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
