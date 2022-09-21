package ocp17.Ch10;

import java.util.Optional;
import java.util.stream.*;
import java.util.*;

public class Advanced {
    private static void threeDigit(Optional<Integer> optional) {
        if (optional.isPresent()) { // outer if
            var num = optional.get();
            var string = "" + num;
            if (string.length() == 3) // inner if
                System.out.println(string);
        }
    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }

    public static void main(String[] args) {
        Optional<Integer> result = optional.map(String::length);

        Optional<Integer> result = optional.map(ChainingOptionals::calculator); // DOES NOT COMPILE

    }

    void spliting() {
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();

        emmasBag.forEachRemaining(System.out::print); // bird-bunny-cat-
        Spliterator<String> jillsBag = originalBagOfFood.trySplit();
        jillsBag.tryAdvance(System.out::print); // dog-
        jillsBag.forEachRemaining(System.out::print); // fish-
        originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse-

        var originalBag = Stream.iterate(1, n -> ++n).spliterator();
        Spliterator<Integer> newBag = originalBag.trySplit();
        newBag.tryAdvance(System.out::print); // 1
        newBag.tryAdvance(System.out::print); // 2
        newBag.tryAdvance(System.out::print); // 3

        var ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears

        var ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result); // 5.333333333333333

        var ohMy = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result = ohMy
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result); // [tigers]

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map); // {lions=5, bears=5, tigers=6}

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = ohMy.collect(Collectors.toMap(
                String::length, k -> k)); // BAD

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = ohMy.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers} System.out.println(map.getClass()); // class
                                 // java.util.HashMap
        var ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map = ohMy.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // class java.util.TreeMap

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        var ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        var ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length,
                        TreeMap::new,
                        Collectors.toList()));
        System.out.println(map);

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map); // {false=[tigers], true=[lions, bears]}

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map); // {false=[], true=[lions, tigers, bears]}

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println(map); // {false=[], true=[lions, tigers, bears]}

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map = ohMy.collect(
                Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map); // {5=2, 6=1}

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map = ohMy.collect(
                Collectors.groupingBy(String::length, Collectors.mapping(
                        s -> s.charAt(0),
                        Collectors.minBy((a, b) -> a - b))));
        System.out.println(map); // {5=Optional[b], 6=Optional[t]}p

        var ohMy = Stream.of("lions", "tigers", "bears");
        var map = ohMy.collect(groupingBy(String::length,
                mapping(s -> s.charAt(0), minBy((a, b) -> a - b))));
        System.out.println(map); // {5=Optional[b], 6=Optional[t]}

        var list = List.of("x", "y", "z");
        Separations result = list.stream()
                .collect(Collectors.teeing(Collectors.joining(" "),
                        Collectors.joining(","),
                        (s, c) -> new Separations(s, c)));
        System.out.println(result);
    }
}
record Separations(String spaceSeparated, String commaSeparated) {}